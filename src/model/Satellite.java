package model;

import java.io.Serializable;


public class Satellite implements Serializable {
    private static final long serialVersionUID = 2388023801353915057L;

    private Long id;

    private String displayName;

    private double satelliteOne;

    private double satelliteTwo;

    private double satelliteThree;

    private String satelliteFour;

    public Satellite(String displayName, double satelliteOne, double satelliteTwo, double satelliteThree, String satelliteFour) {
        this.displayName = displayName;
        this.satelliteOne = satelliteOne;
        this.satelliteTwo = satelliteTwo;
        this.satelliteThree = satelliteThree;
        this.satelliteFour = satelliteFour;
    }

    public Satellite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getSatelliteOne() {
        return satelliteOne;
    }

    public void setSatelliteOne(double satelliteOne) {
        this.satelliteOne = satelliteOne;
    }

    public double getSatelliteTwo() {
        return satelliteTwo;
    }

    public void setSatelliteTwo(double satelliteTwo) {
        this.satelliteTwo = satelliteTwo;
    }

    public double getSatelliteThree() {
        return satelliteThree;
    }

    public void setSatelliteThree(double satelliteThree) {
        this.satelliteThree = satelliteThree;
    }

    public String getSatelliteFour() {
        return satelliteFour;
    }

    public void setSatelliteFour(String satelliteFour) {
        this.satelliteFour = satelliteFour;
    }
}
