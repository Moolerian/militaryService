package model;

import java.io.Serializable;


public class Satellite implements Serializable {
    private static final long serialVersionUID = 2388023801353915057L;

    private Long id;

    private String displayName;

    private Integer satelliteOne;

    private Integer satelliteTwo;

    private Integer satelliteThree;

    private Integer satelliteFour;

    public Satellite(String displayName, Integer satelliteOne, Integer satelliteTwo, Integer satelliteThree, Integer satelliteFour) {
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

    public Integer getSatelliteOne() {
        return satelliteOne;
    }

    public void setSatelliteOne(Integer satelliteOne) {
        this.satelliteOne = satelliteOne;
    }

    public Integer getSatelliteTwo() {
        return satelliteTwo;
    }

    public void setSatelliteTwo(Integer satelliteTwo) {
        this.satelliteTwo = satelliteTwo;
    }

    public Integer getSatelliteThree() {
        return satelliteThree;
    }

    public void setSatelliteThree(Integer satelliteThree) {
        this.satelliteThree = satelliteThree;
    }

    public Integer getSatelliteFour() {
        return satelliteFour;
    }

    public void setSatelliteFour(Integer satelliteFour) {
        this.satelliteFour = satelliteFour;
    }
}
