package com.goalsr.homequarantineTracker.resposemodel;

public class ModelSymptomGVT {

    private String id;
    private String symptomename;

    public ModelSymptomGVT(String id, String symptomename) {
        this.id = id;
        this.symptomename = symptomename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymptomename() {
        return symptomename;
    }

    public void setSymptomename(String symptomename) {
        this.symptomename = symptomename;
    }
}
