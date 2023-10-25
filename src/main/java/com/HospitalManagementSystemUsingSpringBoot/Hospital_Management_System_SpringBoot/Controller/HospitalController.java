package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Controller;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    //get patient by bed number
    @GetMapping("/api/Hospital/getPatient")
    public Patient getPatientByBedNumber(@RequestParam int bedNumber){
        return hospitalService.getPatientFromBedNumber(bedNumber);
    }

    //total beds in hospital
    @GetMapping("/api/Hospital/totalBeds")
    public int totalBeds(){
        return hospitalService.totalbeds();
    }



}
