package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mohammad on 9/22/2016.
 */
public class Facility implements Serializable {
    private static final long serialVersionUID = -1002501885708065689L;

    private Long id;

    private String displayName;

    private Long latitude;

    private Long longitude;

    private Integer facilityOne;

    private Integer facilityTwo;

    private Integer facilityThree;

    private Integer facilityFour;

    private Date startDate;

    private Date endDate;

    private boolean isParent;

    private Long parentId;

    public Facility(Long id ,String displayName, boolean isParent, Long parentId) {
        this.displayName = displayName;
        this.isParent = isParent;
        this.parentId = parentId;
        this.id = id;
    }

    public Facility() {
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

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Integer getFacilityOne() {
        return facilityOne;
    }

    public void setFacilityOne(Integer facilityOne) {
        this.facilityOne = facilityOne;
    }

    public Integer getFacilityTwo() {
        return facilityTwo;
    }

    public void setFacilityTwo(Integer facilityTwo) {
        this.facilityTwo = facilityTwo;
    }

    public Integer getFacilityThree() {
        return facilityThree;
    }

    public void setFacilityThree(Integer facilityThree) {
        this.facilityThree = facilityThree;
    }

    public Integer getFacilityFour() {
        return facilityFour;
    }

    public void setFacilityFour(Integer facilityFour) {
        this.facilityFour = facilityFour;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
