import { useEffect, useState } from "react"
import { Reimbursement } from "../../InterFaces/Reimbursement"
import axios from "axios"
import { Employeeid } from "../../InterFaces/Employeeid"
import { Button, Paper,Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"
import { useNavigate } from "react-router-dom"


export const ReimbursementForEmployeeTable:React.FC<Employeeid> = ({currentEmployeeid}) => {

    const navigate = useNavigate();

    const [reimbursements,setReimbursements] = useState<Reimbursement[]>([])

    useEffect(()=>{
        getAllReimbursementsForEmployee()
    },[])

    const getAllReimbursementsForEmployee = async() => {

        try{
            const response = await axios.get("http://localhost:8080/reimb/employee/" + currentEmployeeid,{withCredentials:true})
            setReimbursements(response.data)

        } catch {
            alert("something has gone awry")
        }


    }


    return(
        <div className="centered">
            <h1>Your Reimbursements ar listed below</h1>

            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} size="small" aria-label="simple table">
                    <TableHead>
                    <TableRow>
                        <TableCell>Reimbursement ID</TableCell>
                        <TableCell align="right">Description</TableCell>
                        <TableCell align="right">Amount&nbsp;(g)</TableCell>
                        <TableCell align="right">Status&nbsp;(g)</TableCell>
                    </TableRow>
                    </TableHead>
                    <TableBody>
                        {reimbursements.map((r) => (
                            <TableRow
                            key={r.reimbursementid}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                            {/* <TableCell component="th" scope="row">
                                {row.name}
                            </TableCell> */}
                            <TableCell align="right">{r.reimbursementid}</TableCell>
                            <TableCell align="right">{r.description}</TableCell>
                            <TableCell align="right">{r.amount}</TableCell>
                            <TableCell align="right">{r.status}</TableCell>
                            </TableRow>
                        ))}
                        </TableBody>
                    </Table>
            </TableContainer>

            <h1>If you would like to submit a new reimbursement, click the button below</h1>
            <Button  onClick={()=>navigate("/submitreimbursement")} variant="contained">Submit Reimbursement</Button>

        </div>



    )
}