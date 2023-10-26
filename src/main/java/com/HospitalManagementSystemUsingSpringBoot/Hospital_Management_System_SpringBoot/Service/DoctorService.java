package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.DoctorRepository;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepo;
    @Autowired
    PatientRepo patientRepo;

    //get minimum patient doctor
    public Doctor getMinDoctorPatient(){
        int min = Integer.MAX_VALUE;
        HashMap<String, ArrayList<Patient>> docVsPatient = doctorRepo.getDocVsPatientsDB();
        Doctor obj = null;
        for(String key : docVsPatient.keySet()){
            ArrayList<Patient> doctorsPatients = docVsPatient.get(key);
            int totalPatients = doctorsPatients.size();
            if(totalPatients < min){
                min = totalPatients;
                obj = doctorRepo.getDoctorDetailsByID(key);
            }
        }
        return obj;

    }

    // doctors patients
    public ArrayList<Patient> getDoctorsPatient(String DoctorID){
        return doctorRepo.getDoctorsPatients(DoctorID);
    }

    //add a doctor
    public void addDoctor(Doctor obj){
        String DoctorID = "Doctor" + (doctorRepo.getOverAllDoctors() + 1);
        obj.setDoctorID(DoctorID);
        doctorRepo.addDoctorToDatabase(obj);
    }

    //get doctor detail
    public Doctor doctorDetail(String DoctorID){
        return doctorRepo.getDoctorDetailsByID(DoctorID);
    }

    //update doctor details
    public void updateDetails(String DoctorID, Doctor obj){
        doctorRepo.updateDoctorDetails(DoctorID, obj);
        patientRepo.updateDoctorDetailsInPatientVsDoctorDatabase(DoctorID, obj);
    }

    //remove patient from doctor
    public void removePatientFromDoctor(String DoctorID, String PatientID){
        doctorRepo.removePatientFromParticularDoctor(DoctorID,PatientID);
    }

    //total doctors
    public int totalDoctor(){
        return doctorRepo.getTotalDoctors();
    }
}
