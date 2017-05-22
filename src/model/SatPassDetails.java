package model;

import util.ExtendedPassPredictor;

/**
 * @author mohammad
 */
public class SatPassDetails {

    public String getSatName() {
        return satName;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getPolePassed() {
        return polePassed;
    }

    public void setPolePassed(String polePassed) {
        this.polePassed = polePassed;
    }

    public int getAos() {
        return aos;
    }

    public void setAos(int aos) {
        this.aos = aos;
    }

    public int getLos() {
        return los;
    }

    public void setLos(int los) {
        this.los = los;
    }

    public double getMaxEl() {
        return maxEl;
    }

    public void setMaxEl(double maxEl) {
        this.maxEl = maxEl;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTca() {
        return tca;
    }

    public void setTca(String tca) {
        this.tca = tca;
    }

    public ExtendedPassPredictor getPassPredictor() {
        return passPredictor;
    }

    public void setPassPredictor(ExtendedPassPredictor passPredictor) {
        this.passPredictor = passPredictor;
    }

    // details variables
    private String satName;
    private String facilityName;
    private String endTime;
    private String startTime;
    private String tca;
    private String polePassed;
    private int aos;
    private int los;
    private double maxEl;
    private ExtendedPassPredictor passPredictor;
    //end of these variables
}
