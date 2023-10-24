package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepo {


    private HashMap<String, Patient> PatientDatabase;
    private int overAllPatients;

    public PatientRepo() {
        this.overAllPatients = 0;
        this.PatientDatabase = new HashMap<>();

    }

    //to get the patient details
    public Patient getPatientDetailsByID(String PatientID){
        return this.PatientDatabase.get(PatientID);
    }

    //to add a patient in a database
    public void addPatient(Patient obj){
        this.overAllPatients += 1;
        this.PatientDatabase.put(obj.getPatientID(), obj);

    }

    // to discharge a patient
    public void dischargePatient(String PatientID){
        this.PatientDatabase.remove(PatientID);
    }

    public int getOverAllPatients(){
        return this.overAllPatients;
    }


    // get total patients
    public int getTotalPatients(){
        return PatientDatabase.size();
    }

}
