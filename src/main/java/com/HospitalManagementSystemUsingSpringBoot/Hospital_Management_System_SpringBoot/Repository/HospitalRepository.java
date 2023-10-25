package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository {

    private Patient[] beds;
    private int bedFee = 500;

    public HospitalRepository() {
        this.beds = new Patient[500];
    }

    //assign bed to the patient
    public void assignBedToPatient(int bedNumber, Patient obj){
        beds[bedNumber] = obj;
    }

    //get the patient at perticular bed
    public Patient getPatientAtParticularBed(int bedNumber){
        return beds[bedNumber];
    }

    //get total beds
    public int totalBeds(){
        return beds.length;
    }

    public Patient[] getAllBeds(){
        return beds;
    }

    public int getBedFee(){
        return bedFee;
    }

}
