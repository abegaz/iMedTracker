package imedtracker.csci3300.csci.mccb.ung.edu.imedtrackermaster;

public class PillModel {
    private String pillName;
    private int doseCount;
    private int doseFrequency;
    private int pillId;
    private int alarmHour;
    private int alarmMin;

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

    public int getAlarmHour() {

        return alarmHour;
    }

    public void setAlarmHour(int alarmHour) {

        this.alarmHour = alarmHour;
    }

    public int getAlarmMin() {

        return alarmMin;
    }

    public void setAlarmMin(int alarmMin) {

        this.alarmMin = alarmMin;
    }

    public PillModel() {

    }

    public PillModel(String pillName, int doseCount, int doseFrequency, int alarmHour, int alarmMin) {

        this.pillName = pillName;
        this.doseCount = doseCount;
        this.doseFrequency = doseFrequency;
        this.alarmHour = alarmHour;
        this.alarmMin = alarmMin;
    }

    @Override
    public String toString() {
        return "PillModel{" +
                "pillName='" + pillName + '\'' +
                "doseCount='" + doseCount + '\'' +
                "doseFrequency='" + doseFrequency + '\'' +
                "alarmHour='" + alarmHour + '\'' +
                "alarmMin='" + alarmMin + '\'' +
                ", pillId=" + pillId +
                '}';
    }
}
