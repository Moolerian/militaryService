package test;

import name.gano.astro.time.Time;
import util.AbstractSatellite;
import util.GroundStation;
import util.SatelliteTleSGP4;
import view.JTrackingPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

/**
 * Created by Mohammad on 9/27/2016.
 */
public class TestTracking {

    private Hashtable<String,AbstractSatellite> satHash = new Hashtable<String, AbstractSatellite>();
    private Hashtable<String,GroundStation> gsHash = new Hashtable<String, GroundStation>();
    private SimpleDateFormat dateformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS z");
    Time currentJulianDate = new Time();

    public void testPass() throws Exception {
        currentJulianDate.setDateFormat(dateformat);

        AbstractSatellite satellite = new SatelliteTleSGP4("ISS (ZARYA)",
                "1 25544U 98067A   16284.17420799  .00006778  00000-0  10957-3 0  9993",
                "2 25544  51.6448 204.4850 0006808  61.5510  95.6847 15.54113582 22876");


        double[] lla = {35.69439,51.42151,0};
        GroundStation groundStation = new GroundStation("Tehran",lla,currentJulianDate.getJulianDate());
        groundStation.setElevationConst(0);

        satHash.put("ISS (ZARYA)             ",satellite);
        gsHash.put("Tehran",groundStation);


        JTrackingPanel trackingBrowser = new JTrackingPanel(satHash,
                gsHash,currentJulianDate.getDateTimeStr(),currentJulianDate);

        JFrame frame = new JFrame("fff");
        frame.add(trackingBrowser);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
    public static void main(String[] args) throws Exception {

        TestTracking testTracking = new TestTracking();
        testTracking.testPass();

    }
}
