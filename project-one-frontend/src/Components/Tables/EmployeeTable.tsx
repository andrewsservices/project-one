import axios from "axios"
import { useEffect, useState } from "react"
import { Employee } from "../../InterFaces/Employee"


import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Button } from "@mui/material";



export const EmployeeTable:React.FC =() => {
    const [employees, setEmployees] = useState<Employee[]>([])

    useEffect(()=>{
        getAllEmployees();
    },[])

    const getAllEmployees = async() => {
        try{
            const response = await axios.get("http://localhost:8080/employees",{withCredentials:true})

            setEmployees(response.data);

        } catch {
            alert("something went awry")
        }
    }



    return(
        <>


           <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} size="small" aria-label="simple table">
                    <TableHead>
                    <TableRow>
                        <TableCell>Employee ID</TableCell>
                        <TableCell align="right">First Name</TableCell>
                        <TableCell align="right">Last Name</TableCell>
                        <TableCell align="right">Title</TableCell>
                        <TableCell align="right">Change Status</TableCell>
                    </TableRow>
                    </TableHead>
                    <TableBody>
                    {employees.map((e) => (
                        <TableRow
                        key={e.employeeid}
                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >
                        {/* <TableCell component="th" scope="row">
                            {row.name}
                        </TableCell> */}
                        <TableCell align="right">{e.employeeid}</TableCell>
                        <TableCell align="right">{e.firstname}</TableCell>
                        <TableCell align="right">{e.lastname}</TableCell>
                        <TableCell align="right">{e.title}</TableCell>
                        <TableCell align="right">
                                <Button variant="contained">Promote</Button>
                                <Button variant="outlined">Fire</Button>
                            </TableCell>
                        </TableRow>
                    ))}
                    </TableBody>
                </Table>
        </TableContainer>
        </>
    )
}