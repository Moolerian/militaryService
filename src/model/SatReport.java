package model;

import java.io.Serializable;


public class SatReport implements Serializable {

    private Long id;
    private String name;
    private String madeIn;
    private String launchDate;
    private Long Tilt;
    private Long altitude;
    private Long RCS;
    private String circuit;
    private Long satelliteLife;
    private String sensor;
    private String sensorType;
    private Long spatialResolution;
    private Long temporalResolution;
    private Long radiometricResolution;
    private Long widthPassage;
    private Long bondNumber;
    private Long spectralRange;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public Long getTilt() {
        return Tilt;
    }

    public void setTilt(Long tilt) {
        Tilt = tilt;
    }

    public Long getAltitude() {
        return altitude;
    }

    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    public Long getRCS() {
        return RCS;
    }

    public void setRCS(Long RCS) {
        this.RCS = RCS;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public Long getSatelliteLife() {
        return satelliteLife;
    }

    public void setSatelliteLife(Long satelliteLife) {
        this.satelliteLife = satelliteLife;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Long getSpatialResolution() {
        return spatialResolution;
    }

    public void setSpatialResolution(Long spatialResolution) {
        this.spatialResolution = spatialResolution;
    }

    public Long getTemporalResolution() {
        return temporalResolution;
    }

    public void setTemporalResolution(Long temporalResolution) {
        this.temporalResolution = temporalResolution;
    }

    public Long getRadiometricResolution() {
        return radiometricResolution;
    }

    public void setRadiometricResolution(Long radiometricResolution) {
        this.radiometricResolution = radiometricResolution;
    }

    public Long getWidthPassage() {
        return widthPassage;
    }

    public void setWidthPassage(Long widthPassage) {
        this.widthPassage = widthPassage;
    }

    public Long getBondNumber() {
        return bondNumber;
    }

    public void setBondNumber(Long bondNumber) {
        this.bondNumber = bondNumber;
    }

    public Long getSpectralRange() {
        return spectralRange;
    }

    public void setSpectralRange(Long spectralRange) {
        this.spectralRange = spectralRange;
    }
}
