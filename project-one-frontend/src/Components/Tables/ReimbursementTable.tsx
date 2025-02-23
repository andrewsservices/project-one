import { useEffect, useState } from "react"
import { Reimbursement } from "../../InterFaces/Reimbursement"
import axios from "axios"
import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@mui/material"
import { useNavigate } from "react-router-dom"


export const ReimbursementTable:React.FC = () => {
    const [reimbursements,setReimbursements] = useState<Reimbursement[]>([])

    const navigate = useNavigate()

    const approveReimbursement = (id:number) => {
        alert("Reimbursement number: " + id + " was approved");
    }

    const denyReimbursement = async (id:number) => {


        try{
            const response = await axios.post("http://localhost:8080/reimb/deny")
            alert("Reimbursement number: " + id + " was denied");
        } catch {
            alert("denial unsuccessful")
        }


    }

    useEffect(()=>{
        getAllReimbursements()
    },[])

    const getAllReimbursements = async() => {

        try{
            const response = await axios.get("http://localhost:8080/reimb",{withCredentials:true})
            setReimbursements(response.data)

        } catch {
            alert("something has gone awry")
        }


    }

    const updateRequest = (reimbursement:Reimbursement) => {
        alert("Reimbursement " + reimbursement.reimbursementid + " has been fake updated or deleted")

        //TODO: Could definitely make another call to getAllUsers for automatic updates
        //TODO2: Cache the list of users and update THAT so we don't make a repeat DB call
    }

    return(
        <>
            <Button variant="outlined" onClick={()=>navigate("/employeetable")}>Go To Employees</Button>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} size="small" aria-label="simple table">
                    <TableHead>
                    <TableRow>
                        <TableCell>Reimbursement ID</TableCell>
                        <TableCell align="right">Description</TableCell>
                        <TableCell align="right">Amount</TableCell>
                        <TableCell align="right">Status</TableCell>
                        <TableCell align="right">Employee ID</TableCell>
                        <TableCell align="right">Change Reimbursement Status</TableCell>
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
                            <TableCell align="right">{r.employeeid}</TableCell>
                            <TableCell align="right">
                                <Button variant="contained" onClick={approveReimbursement}>Approved</Button>
                                <Button variant="outlined">Declined</Button>
                            </TableCell>
                            </TableRow>
                        ))}
                        </TableBody>
                    </Table>
            </TableContainer>

        </>



    )
}