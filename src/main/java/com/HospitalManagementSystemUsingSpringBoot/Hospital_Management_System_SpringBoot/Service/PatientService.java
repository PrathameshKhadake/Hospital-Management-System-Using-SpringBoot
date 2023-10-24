package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

    //add patient in database
    public void addPatientToDatabase(Patient obj){
        String PatientID = "Patient" + (patientRepo.getOverAllPatients() + 1);
        obj.setPatientID(PatientID);
        patientRepo.addPatient(obj);
    }

    // discharge patient
    public void dischargePatient(String PatientID){
        patientRepo.dischargePatient(PatientID);
    }

    // get Patient details
    public Patient getPatientDetail(String PatientID){
        return patientRepo.getPatientDetailsByID(PatientID);
    }

    // total patient
    public int totalPatient(){
        return patientRepo.getTotalPatients();
    }
}
