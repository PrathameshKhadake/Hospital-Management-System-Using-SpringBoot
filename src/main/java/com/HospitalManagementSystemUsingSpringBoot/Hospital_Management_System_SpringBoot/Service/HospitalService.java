package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    // to get the first empty bed
    public int getFirstEmptyBed(){

        Patient beds[] = hospitalRepository.getAllBeds();
        for(int i = 0; i < beds.length; i++){
            if(beds[i] == null){
                return i;
            }
        }
        return -1;
    }

    // assign patient to bed number
    public void assignPatientToBed(int bedNumber, Patient obj){
        hospitalRepository.assignBedToPatient(bedNumber, obj);
    }

    //get patient from bed number
    public Patient getPatientFromBedNumber(int bedNumber){
        return hospitalRepository.getPatientAtParticularBed(bedNumber);
    }

    //total beds
    public int totalbeds(){
        return hospitalRepository.totalBeds();
    }
}
