package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Controller;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    //add doctor
    @PostMapping("/api/Doctor/addDoctor")
    public String addDoctor(@RequestBody Doctor obj){
        doctorService.addDoctor(obj);
        return "Doctor added successfully.";
    }

    //get doctor details
    @GetMapping("/api/Doctor")
    public Doctor getDoctor(@RequestParam String DoctorID){
        return doctorService.doctorDetail(DoctorID);
    }

    //get total doctors
    @GetMapping("/api/Doctor/TotalDoctors")
    public int totalDoctors(){
        return doctorService.totalDoctor();
    }

    //update doctor details
    @PutMapping("/api/Doctor")
    public String updateDetails(@RequestParam String DoctorID, @RequestBody Doctor obj){
        doctorService.updateDetails(DoctorID, obj);
        return DoctorID + " data updated successfully.";
    }

    //get all patients of doctor
    @GetMapping("/api/Doctor/getAllPatients/{DoctorID}")
    public ArrayList<Patient> getAllPatients(@PathVariable String DoctorID){
        return doctorService.getDoctorsPatient(DoctorID);
    }

}
