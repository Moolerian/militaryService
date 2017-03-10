package test;

import uk.me.g4dpz.satellite.*;

import java.util.Date;
import java.util.List;

/**
 * @author mohammad
 */
public class Main {
    private static final String[] NOAA_TLE = {
            "NOAA 19",
            "1 33591U 09005A   17064.54161353  .00000136  00000-0  99196-4 0  9999",
            "2 33591  99.0798  29.9671 0013530 200.0362 160.0279 14.12158381416037"};
    private static final GroundStationPosition GROUND_STATION = new GroundStationPosition(35.67, 51.43, 0);


    public static void main(String[] args) throws SatNotFoundException, InvalidTleException {

        final TLE tle = new TLE(NOAA_TLE);

        final PassPredictor passPredictor = new PassPredictor(tle, GROUND_STATION);

        final List<SatPassTime> passes = passPredictor.getPasses(
                new Date(), 24, true);

        System.out.println(passes);
    }
}
