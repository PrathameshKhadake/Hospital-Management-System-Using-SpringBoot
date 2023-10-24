package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DoctorRepository {

    private HashMap<String, Doctor> doctorDatabase;
    private int overAllDoctors;

    public DoctorRepository(){
        this.doctorDatabase = new HashMap<>();
        this.overAllDoctors = 0;
    }

    //add doctor to database
    public void addDoctorToDatabase(Doctor obj){
        this.overAllDoctors += 1;
        doctorDatabase.put(obj.getDoctorID(), obj);
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
