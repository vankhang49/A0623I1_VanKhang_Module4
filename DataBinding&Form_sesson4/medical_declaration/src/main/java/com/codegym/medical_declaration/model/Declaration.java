package com.codegym.medical_declaration.model;


import java.util.List;

public class Declaration {
    private Integer id;
    private String name;
    private Integer yearOfBirth;
    private String gender;
    private String nationality;
    private String identifier;
    private String travelInfo;
    private String vehicleNumber;
    private String seats;
    private String departureDay;
    private String endDate;
    private String travelHistory;
    private String contactAddress;
    private String address;
    private String phoneNumber;
    private String email;
    private List<String> symptoms;
    private List<String> exposureHistory;

    public Declaration() {
    }

    public Declaration(Integer id, String name, Integer yearOfBirth, String gender, String nationality, String identifier,
                       String travelInfo, String vehicleNumber, String seats, String departureDay, String endDate,
                       String travelHistory, String contactAddress, String address, String phoneNumber,
                       String email, List<String> symptoms, List<String> exposureHistory) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.identifier = identifier;
        this.travelInfo = travelInfo;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.travelHistory = travelHistory;
        this.contactAddress = contactAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptoms = symptoms;
        this.exposureHistory = exposureHistory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(List<String> exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
