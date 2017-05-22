package util;

import com.github.amsacode.predict4java.*;
import gov.nasa.worldwind.geom.LatLon;

import java.util.*;

/**
 * @author mohammad
 */
public class ExtendedPassPredictor extends PassPredictor {

    private final TLE tle;
    private final GroundStationPosition qth;
    private double widthPassage;

    public ExtendedPassPredictor(TLE theTLE, GroundStationPosition theQTH) throws IllegalArgumentException, SatNotFoundException {
        super(theTLE, theQTH);
        this.tle = theTLE;
        this.qth = theQTH;
    }

    public void setWidthPassage(double widthPassage) {
        this.widthPassage = widthPassage;
    }

    public double getWidthPassage() {
        return widthPassage;
    }

    private static final String UTC = "UTC";
    private static final TimeZone TZ = TimeZone.getTimeZone(UTC);

    @SuppressWarnings("Duplicates")
    @Override
    public SatPassTime nextSatPass(Date date, boolean windBack) throws SatNotFoundException {
        int aosAzimuth;
        int losAzimuth;
        double maxElevation = 0;
        double elevation = 0;

        // get the current position
        final Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTimeInMillis(date.getTime());

        SatPos satPos = getSatPos(cal.getTime());

        double longitude = satPos.getLongitude() / 6.283185307179586D * 360.0D;
        LatLon satPosLatLon = LatLon.fromDegrees(satPos.getLatitude() / 6.283185307179586D * 360.0D
                , (longitude > 180) ? longitude - 360 : longitude);
        LatLon groundLatLon = LatLon.fromDegrees(qth.getLatitude(), qth.getLongitude());
        double distance = LatLon.ellipsoidalDistance(satPosLatLon, groundLatLon, 6378.1370, 6356.7523);
        double diff = distance - widthPassage;

        if (diff > 0.0) {
            do {
                satPos = getPosition(cal, 30);

                longitude = satPos.getLongitude() / 6.283185307179586D * 360.0D;
                satPosLatLon = LatLon.fromDegrees(satPos.getLatitude() / 6.283185307179586D * 360.0D
                        , (longitude > 180) ? longitude - 360 : longitude);
                distance = LatLon.ellipsoidalDistance(satPosLatLon, groundLatLon, 6378.1370, 6356.7523);
                diff = distance - widthPassage;

                elevation = satPos.getElevation();
                if (elevation > maxElevation) {
                    maxElevation = elevation;
                }

                if (cal.getTime().compareTo(trackEndDate) > 0) {
                    return null;
                }
            } while (diff > 0.0);
        }

        cal.add(Calendar.SECOND, -30);
        do {
            satPos = getPosition(cal, 1);

            longitude = satPos.getLongitude() / 6.283185307179586D * 360.0D;
            satPosLatLon = LatLon.fromDegrees(satPos.getLatitude() / 6.283185307179586D * 360.0D
                    , (longitude > 180) ? longitude - 360 : longitude);
            distance = LatLon.ellipsoidalDistance(satPosLatLon, groundLatLon, 6378.1370, 6356.7523);
            diff = distance - widthPassage;

            elevation = satPos.getElevation();
            if (elevation > maxElevation) {
                maxElevation = elevation;
            }

        } while (diff > 0.0);
        // ints start time
        final Date startDate = satPos.getTime();
        aosAzimuth = (int) ((satPos.getAzimuth() / (2.0 * Math.PI)) * 360.0);

        // now its going for end time
        do {
            satPos = getPosition(cal, 1);

            longitude = satPos.getLongitude() / 6.283185307179586D * 360.0D;
            satPosLatLon = LatLon.fromDegrees(satPos.getLatitude() / 6.283185307179586D * 360.0D
                    , (longitude > 180) ? longitude - 360 : longitude);
            groundLatLon = LatLon.fromDegrees(qth.getLatitude(), qth.getLongitude());
            distance = LatLon.ellipsoidalDistance(satPosLatLon, groundLatLon, 6378.1370, 6356.7523);
            diff = distance - widthPassage;

            elevation = satPos.getElevation();
            if (elevation > maxElevation) {
                maxElevation = elevation;
            }

        } while (diff < 0.0);

        // its end time
        final Date endDate = satPos.getTime();
        losAzimuth = (int) ((satPos.getAzimuth() / (2.0 * Math.PI)) * 360.0);

        return new SatPassTime(startDate, endDate, new Date(), "", aosAzimuth,
                losAzimuth, (maxElevation / (2.0 * Math.PI)) * 360.0);
    }

    private SatPos getPosition(final Calendar cal, final int offSet)
            throws SatNotFoundException {
        SatPos satPos;
        cal.add(Calendar.SECOND, offSet);
        satPos = getSatPos(cal.getTime());
        return satPos;
    }

    private Date trackEndDate;

    @Override
    public List<SatPassTime> getPasses(Date start, int hoursAhead, boolean windBack) throws SatNotFoundException {
        final List<SatPassTime> passes = new ArrayList<>();

        Date trackStartDate = start;
        trackEndDate = new Date(start.getTime()
                + (hoursAhead * 60L * 60L * 1000L));

        Date lastAOS;

        do {
            final SatPassTime pass = nextSatPass(trackStartDate, false);
            if (pass == null) {
                break;
            }
            lastAOS = pass.getStartTime();
            passes.add(pass);
            trackStartDate = new Date(pass.getEndTime().getTime()
                    + (threeQuarterOrbitMinutes() * 60L * 1000L));

        } while (lastAOS.compareTo(trackEndDate) < 0);

        return passes;
    }

    private int threeQuarterOrbitMinutes() {
        return (int) (24.0 * 60.0 / tle.getMeanmo() * 0.75);
    }
}
