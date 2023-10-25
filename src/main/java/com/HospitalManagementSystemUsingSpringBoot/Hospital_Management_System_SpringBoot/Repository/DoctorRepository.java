package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {

    private HashMap<String, Doctor> doctorDatabase;
    private HashMap<String, ArrayList<Patient>> docVsPatient;
    private int overAllDoctors;

    public DoctorRepository(){
        this.docVsPatient = new HashMap<>();
        this.doctorDatabase = new HashMap<>();
        this.overAllDoctors = 0;
    }

    // assign patient to doctor
    public void assignPatientToDoctor(String DoctorID, Patient obj){
        ArrayList<Patient> patient = this.docVsPatient.get(DoctorID);
        patient.add(obj);
    }

    //add doctor to database
    public void addDoctorToDatabase(Doctor obj){
        this.overAllDoctors += 1;
        docVsPatient.put(obj.getDoctorID(), new ArrayList<>());
        doctorDatabase.put(obj.getDoctorID(), obj);
    }

    //to get doctor having the patients list
    public ArrayList<Patient> getDoctorsPatients(String DoctorID){
        return docVsPatient.get(DoctorID);
    }

    //to get the doctor vs patients database
    public HashMap<String, ArrayList<Patient>> getDocVsPatientsDB(){
        return docVsPatient;
    }

    //get doctor details
    public Doctor getDoctorDetailsByID(String DoctorID){
        return doctorDatabase.get(DoctorID);
    }

    //total numbers of doctors
    public int getTotalDoctors(){
        return doctorDatabase.size();
    }

    //over all doctors
    public int getOverAllDoctors(){
        return this.overAllDoctors;
    }

    //update doctor detail
    public void updateDoctorDetails(String DoctorID, Doctor obj){
        doctorDatabase.put(DoctorID, obj);
    }

}
