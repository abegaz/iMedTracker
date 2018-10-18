package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

public class PillModel {
    private String pillName;
    private int doseCount;
    private int doseFrequency;
    private int pillId;

    public int getPillId() {

        return pillId;
    }

    public void setPillId(int pillId) {

        this.pillId = pillId;
    }

    public String getPillName() {

        return pillName;
    }

    public void setPillName(String pillName) {

        this.pillName = pillName;
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

    public PillModel() {

    }

    public PillModel(String pillName, int doseCount, int doseFrequency) {

        this.pillName = pillName;
        this.doseCount = doseCount;
        this.doseFrequency = doseFrequency;
    }

    @Override
    public String toString() {
        return "PollModel{" +
                "pillName='" + pillName + '\'' +
                "doseCount='" + doseCount + '\'' +
                "doseFrequency='" + doseFrequency + '\'' +
                ", pillId=" + pillId +
                '}';
    }
}
