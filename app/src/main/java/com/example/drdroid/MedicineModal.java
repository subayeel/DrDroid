package com.example.drdroid;

public class MedicineModal {

    private String medId;
    private String medName;
    private String medDose;
    private String medTime;
    private String medType;

    private String isSunday;
    private String isMonday;
    private String isTuesday;
    private String isWednesday;
    private String isThursday;
    private String isFriday;
    private String isSaturday;



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

    public String getIsSunday(){return isSunday;}
    public void setIsSunday(){this.isSunday=isSunday;}

    public String getIsMonday(){return isMonday;}
    public void setIsMonday(){this.isMonday=isMonday;}

    public String getIsTuesday(){return isTuesday;}
    public void setIsTuesday(){this.isTuesday=isTuesday;}

    public String getIsWednesday(){return isWednesday;}
    public void setIsWednesday(){this.isWednesday=isWednesday;}

    public String getIsThursday(){return isThursday;}
    public void setIsThursday(){this.isThursday=isThursday;}

    public String getIsFriday(){return isFriday;}
    public void setIsFriday(){this.isFriday=isFriday;}

    public String getIsSaturday(){return isSaturday;}
    public void setIsSaturday(){this.isSaturday=isSaturday;}

    public  MedicineModal(
            String medId,
            String medName,
            String medDose,
            String medType,
            String medTime,
            String isSunday,
            String isMonday,
            String isTuesday,
            String isWednesday,
            String isThursday,
            String isFriday,
            String isSaturday){
        this.medId = medId;
        this.medName = medName;
        this.medType = medType;
        this.medTime = medTime;
        this.medDose = medDose;
        this.isSunday = isSunday;
        this.isMonday = isMonday;
        this.isTuesday = isTuesday;
        this.isWednesday = isWednesday;
        this.isThursday = isThursday;
        this.isFriday = isFriday;
        this.isSaturday = isSaturday;

    }

}
