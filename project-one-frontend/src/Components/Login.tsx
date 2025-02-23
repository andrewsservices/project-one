import axios from "axios";
import { LoginProps } from "../InterFaces/LoginProps";
import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { store } from "../GlobalData/store";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";


export const Login:React.FC<LoginProps> = ({setCurrentEmployeeid}) => {


    const navigate = useNavigate()


    const userNameRef = useRef<HTMLInputElement>(null);

    useEffect(()=>{
        if(userNameRef.current){
            userNameRef.current.focus();
        }
    })

    const[loginCreds, setLoginCreds] = useState({
        username: "",
        password: ""
    })

    const storeValues = (event:React.ChangeEvent<HTMLInputElement>) => {
        const name = event.target.name;
        const value = event.target.value;

        setLoginCreds((loginCreds)=>({...loginCreds,[name]: value}))
    }

    const login = async () => {
        try{
            const response = await axios.post("http://localhost:8080/auth/login",loginCreds,{withCredentials:true})
            store.loggedInEmployee = response.data;
            const currentEmployee = store.loggedInEmployee;
            setCurrentEmployeeid(currentEmployee.employeeid);
            alert(store.loggedInEmployee.username + " has logged in , welcome.  You are a " + store.loggedInEmployee.title + " employee");
            if(store.loggedInEmployee.title === "manager"){
                navigate("/reimb")
            } else {
                navigate("/basic")
            }
        } catch{
            alert("login unsuccessful")
        }
    }


    return(

        <div className="centered">
            <h1>Log In</h1>

            <TextField ref={userNameRef} name="username" id="outlined-basic" label="User Name" variant="outlined" onChange={storeValues}/>
            <TextField type="password" name="password" id="outlined-basic" label="Password" variant="outlined" onChange={storeValues}/>


            <div>
            <Button  onClick={login} variant="contained">Log In</Button>
            <Button onClick={()=>navigate("/register")} variant="contained">Register</Button>
            </div>

        </div>

    )
}