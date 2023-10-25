package com.HospitalManagementSystemUsingSpringBoot.Hospital_Management_System_SpringBoot.Model;

public class Bill {

    private int doctorFee;
    private int bedFee;
    private int totalBill;

    public Bill(int doctorFee, int bedFee, int totalBill) {
        this.doctorFee = doctorFee;
        this.bedFee = bedFee;
        this.totalBill = totalBill;
    }

    public int getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(int doctorFee) {
        this.doctorFee = doctorFee;
    }

    public int getBedFee() {
        return bedFee;
    }

    public void setBedFee(int bedFee) {
        this.bedFee = bedFee;
    }

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }
}
