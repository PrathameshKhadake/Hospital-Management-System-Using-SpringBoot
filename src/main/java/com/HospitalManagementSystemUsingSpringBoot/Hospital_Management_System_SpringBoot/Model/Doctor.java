package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model;

public class Doctor {
    private String DoctorID;
    private String DoctorName;
    private String DoctorDegree;
    private String DoctorGender;
    private int DoctorAge;
    private int DoctorFee;

    public Doctor(String doctorID, String doctorName, String doctorDegree, String doctorGender, int doctorAge, int doctorFee) {
        this.DoctorID = doctorID;
        this.DoctorName = doctorName;
        this.DoctorDegree = doctorDegree;
        this.DoctorGender = doctorGender;
        this.DoctorAge = doctorAge;
        this.DoctorFee = doctorFee;
    }

    public String getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(String doctorID) {
        this.DoctorID = doctorID;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        this.DoctorName = doctorName;
    }

    public String getDoctorDegree() {
        return DoctorDegree;
    }

    public void setDoctorDegree(String doctorDegree) {
        this.DoctorDegree = doctorDegree;
    }

    public String getDoctorGender() {
        return DoctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.DoctorGender = doctorGender;
    }

    public int getDoctorAge() {
        return DoctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.DoctorAge = doctorAge;
    }

    public int getDoctorFee() {
        return DoctorFee;
    }

    public void setDoctorFee(int doctorFee) {
        DoctorFee = doctorFee;
    }
}
