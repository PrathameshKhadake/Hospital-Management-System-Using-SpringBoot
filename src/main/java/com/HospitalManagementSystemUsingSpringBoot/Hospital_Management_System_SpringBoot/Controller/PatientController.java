package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Controller;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    //admit patient
    @PostMapping("/api/Patient/addPatient")
    public String admitPatient(@RequestBody Patient obj){
        patientService.addPatientToDatabase(obj);
        return "Patient is Admitted.";
    }

    //get patient details
    @GetMapping("/api/Patient")
    public Patient getPatientDetail(@RequestParam String PatientID){
        return patientService.getPatientDetail(PatientID);
    }

    //discharge patient
    @DeleteMapping("/api/Patient")
    public String dischargePatient(@RequestParam String PatientID){
        patientService.dischargePatient(PatientID);
        return "Patient No. " +  PatientID + " Patient is Discharged.";
    }

    //total patients
    @GetMapping("/api/Patient/TotalPatients")
    public int totalPatient(){
       return patientService.totalPatient();
    }

    //get patients doctor
    @GetMapping("/api/Patient/getDoctor/{PatientID}")
    public Doctor getDoctor(@PathVariable String PatientID){
        return patientService.getPatientDoctor(PatientID);
    }
}
