package com.example.drdroid;

public class MedicineModal {

    private String medId;
    private String medName;
    private String medDose;
    private String medTime;
    private String medType;

    public String getMedId(){
        return medId;
    }
    public void setMedId(String medId){
        this.medId = medId;
    }
    public String getMedName(){
        return medName;
    }
    public void setMedName(String medName){
        this.medName = medName;
    }
    public String getMedDose(){
        return medDose;
    }
    public void setMedDose(String medDose){
        this.medDose =medDose;
    }

    public String getMedTime(){
        return medTime;
    }
    public void setMedTime(String medTime){
        this.medTime = medTime;
    }

    public String getMedType(){
        return medType;
    }
    public void setMedType(String medType){
        this.medType = medType;
    }

    public MedicineModal(String medId,String medName,String medDose,String medType,String medTime){
        this.medId = medId;
        this.medName = medName;
        this.medType = medType;
        this.medTime = medTime;
        this.medDose = medDose;

    }

}
