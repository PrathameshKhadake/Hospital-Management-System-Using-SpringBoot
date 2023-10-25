package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Service;

import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Bill;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Doctor;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model.Patient;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.DoctorRepository;
import com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalService hospitalService;

    //add patient in database
    public void addPatientToDatabase(Patient obj){
        String PatientID = "Patient" + (patientRepo.getOverAllPatients() + 1);
        obj.setPatientID(PatientID);

        int bedNumber = hospitalService.getFirstEmptyBed();
        hospitalService.assignPatientToBed(bedNumber, obj);

        Doctor doctor = doctorService.getMinDoctorPatient();
        patientRepo.assignDoctorToPatient(PatientID, doctor);
        doctorRepository.assignPatientToDoctor(doctor.getDoctorID(), obj);

        patientRepo.addPatient(obj);
    }

    //get patients doctor
    public Doctor getPatientDoctor(String PatientID){
        return patientRepo.getPatientDoctorByID(PatientID);
    }

    // discharge patient
    public Bill dischargePatient(String PatientID, String PatientDischargeDate){

        Patient obj = patientRepo.getPatientDetailsByID(PatientID);
        String admitDate = obj.getPatientAdmitDate();
        String admitDateArray[] = admitDate.split("-");
        String dischargeDateArray[] = PatientDischargeDate.split("-");
        int difference = Integer.parseInt(dischargeDateArray[0]) - Integer.parseInt(admitDateArray[0]);
        Doctor docObj = patientRepo.getPatientDoctorByID(PatientID);
        int docFee = docObj.getDoctorFee();
        int bedFee = hospitalService.getBedFee();
        int totalBill = difference * (docFee + bedFee);

        Bill patientBill = new Bill(docFee, bedFee, totalBill);

        patientRepo.dischargePatient(PatientID);

        return patientBill;
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
