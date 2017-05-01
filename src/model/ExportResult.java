package model;

/**
 * @author mohammad
 */
@Deprecated
public class ExportResult {
    private String facilityName;
    private String satName;
    private String calculatingDate;
    private String startTime;
    private String endTime;


    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getSatName() {
        return satName;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    public String getCalculatingDate() {
        return calculatingDate;
    }

    public void setCalculatingDate(String calculatingDate) {
        this.calculatingDate = calculatingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
