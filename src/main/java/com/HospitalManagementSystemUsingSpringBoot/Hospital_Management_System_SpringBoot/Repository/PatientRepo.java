package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepo {


    private HashMap<String, Patient> PatientDatabase;
    private HashMap<String, Doctor> patientVsDoctor;
    private int overAllPatients;

    public PatientRepo() {
        this.patientVsDoctor = new HashMap<>();
        this.overAllPatients = 0;
        this.PatientDatabase = new HashMap<>();

    }

    //assign doctor to patient
    public void assignDoctorToPatient(String PatientID, Doctor obj){
        this.patientVsDoctor.put(PatientID, obj);
    }

    //get patient doctor
    public Doctor getPatientDoctorByID(String PatientID){
        return patientVsDoctor.get(PatientID);
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
        this.patientVsDoctor.remove(PatientID);
    }

    public int getOverAllPatients(){
        return this.overAllPatients;
    }


    // get total patients
    public int getTotalPatients(){
        return PatientDatabase.size();
    }

    // update doctor details in patient vs doctor database
    public void updateDoctorDetailsInPatientVsDoctorDatabase(String DoctorID, Doctor obj){

        for(String key : patientVsDoctor.keySet()){
            Doctor docObj = patientVsDoctor.get(key);
            if(docObj.getDoctorID().equals(DoctorID)){
                patientVsDoctor.put(key, obj);
            }
        }
    }


}
