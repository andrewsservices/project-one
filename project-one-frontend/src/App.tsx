import Box from '@mui/material/Box'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import { Login } from './Components/Login'
import { Register } from './Components/Register'
import { useState } from 'react'
import { ReimbursementForEmployeeTable } from './Components/Tables/ReimbursementForEmployeeTable'
import { ReimbursementTable } from './Components/Tables/ReimbursementTable'
import { EmployeeTable } from './Components/Tables/EmployeeTable'
import { ReimbursementForm } from './Components/ReimbursementForm'


function App() {

const [currentEmployeeid,setCurrentEmployeeid] = useState(0);

  return (


    <Box sx={{ width: '100%', maxWidth: 800 }} >
          <BrowserRouter>
            <Routes>
            < Route path="" element={
              <Login
                setCurrentEmployeeid={setCurrentEmployeeid}
              />
              }/>
              <Route path="register" element={
                <Register
                setCurrentEmployeeid={setCurrentEmployeeid}
                />}/>
              <Route path="employeetable" element={<EmployeeTable/>}/>
              <Route path="basic" element={
                <ReimbursementForEmployeeTable
                  currentEmployeeid={currentEmployeeid}
                />}/>
              <Route path="manager" element={<ReimbursementTable/>}/>
              <Route path="submitreimbursement" element={<ReimbursementForm currentEmployeeid={currentEmployeeid}/>}/>
            </Routes>

          </BrowserRouter>
        </Box>




  )
}

export default App
