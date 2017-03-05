package model;

import java.io.Serializable;

/**
 * @author mohammad
 */
public class Result implements Serializable{

    private String facilityName ;
    private String satName ;
    private String riseDate ;
    private String duration ;

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

    public String getRiseDate() {
        return riseDate;
    }

    public void setRiseDate(String riseDate) {
        this.riseDate = riseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "خطر";
    }
}
