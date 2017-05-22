package model;

import util.ExtendedPassPredictor;

import java.util.Date;

/**
 * @author mohammad
 */
public class ExtendedSatPassTime {
    private String satName;
    private String facilityName;
    private Date startTime;
    private Date endTime;
    private Date tca;
    private String polePassed;
    private int aos;
    private int los;
    private double maxEl;
    private ExtendedPassPredictor passPredictor;

    public String getSatName() {
        return satName;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getTca() {
        return tca;
    }

    public void setTca(Date tca) {
        this.tca = tca;
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

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public ExtendedPassPredictor getPassPredictor() {
        return passPredictor;
    }

    public void setPassPredictor(ExtendedPassPredictor passPredictor) {
        this.passPredictor = passPredictor;
    }
}
