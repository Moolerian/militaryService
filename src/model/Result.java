package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author mohammad
 */
@Deprecated
public class Result implements Serializable {

    private String facilityName;
    private List<String> satName;
    private Date date;
    private Date startDate;
    private Date endDate;
    private List<int[]> line;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public List<String> getSatName() {
        return satName;
    }

    public void setSatName(List<String> satName) {
        this.satName = satName;
    }

    public List<int[]> getLine() {
        return line;
    }

    public void setLine(List<int[]> line) {
        this.line = line;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
