package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model;

public class Patient {
    private String PatientID;
    private String PatientName;
    private String PatientGender;
    private int PatientAge;
    private String PatientAddress;
    private String PatientDesease;

    public Patient(String patientID, String patientName, String patientGender, int patientAge, String patientAddress, String patientDesease) {
        this.PatientID = patientID;
        this.PatientName = patientName;
        this.PatientGender = patientGender;
        this.PatientAge = patientAge;
        this.PatientAddress = patientAddress;
        this.PatientDesease = patientDesease;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        this.PatientID = patientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        this.PatientName = patientName;
    }

    public String getPatientGender() {
        return PatientGender;
    }

    public void setPatientGender(String patientGender) {
        this.PatientGender = patientGender;
    }

    public int getPatientAge() {
        return PatientAge;
    }

    public void setPatientAge(int patientAge) {
        this.PatientAge = patientAge;
    }

    public String getPatientAddress() {
        return PatientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.PatientAddress = patientAddress;
    }

    public String getPatientDesease() {
        return PatientDesease;
    }

    public void setPatientDesease(String patientDesease) {
        this.PatientDesease = patientDesease;
    }
}
