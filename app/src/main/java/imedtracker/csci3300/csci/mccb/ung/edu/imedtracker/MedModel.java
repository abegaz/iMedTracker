package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

public class MedModel{
    private String medName;
    private int doseCount;
    private int doseFrequency;
    private int medId;

    public int getMedId() {

        return medId;
    }

    public void setMedId(int medId) {

        this.medId = medId;
    }

    public String getMedName() {

        return medName;
    }

    public void setMedName(String medName) {

        this.medName = medName;
    }

    public int getDoseCount() {

        return doseCount;
    }

    public void setDoseCount(int doseCount) {

        this.doseCount = doseCount;
    }

    public int getDoseFrequency() {

        return doseFrequency;
    }

    public void setDoseFrequency(int doseFrequency) {

        this.doseFrequency = doseFrequency;
    }

    public MedModel() {

    }

    public MedModel(String medName, int doseCount, int doseFrequency) {

        this.medName = medName;
        this.doseCount = doseCount;
        this.doseFrequency = doseFrequency;
    }

    @Override
    public String toString() {
        return "MedModel{" +
                "medName='" + medName + '\'' +
                "doseCount='" + doseCount + '\'' +
                "doseFrequency='" + doseFrequency + '\'' +
                ", medId=" + medId +
                '}';
    }
}

