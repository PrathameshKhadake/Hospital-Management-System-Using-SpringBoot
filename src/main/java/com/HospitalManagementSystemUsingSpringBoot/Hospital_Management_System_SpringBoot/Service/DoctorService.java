package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepo;

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
    }

    //total doctors
    public int totalDoctor(){
        return doctorRepo.getTotalDoctors();
    }
}
