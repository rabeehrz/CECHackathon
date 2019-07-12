package com.sudowodo.cechack;

public class patientDetails {
    private String Name;
    private String Age;
    private String NurseID;
    private String diseaseType;
    private String key;

    patientDetails(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getNurseID() {
        return NurseID;
    }

    public void setNurseID(String nurseID) {
        NurseID = nurseID;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
