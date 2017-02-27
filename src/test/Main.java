//package test;
//
//import jsattrak.gui.J3DEarthPanel;
//import jsattrak.gui.JSatTrak;
//import jsattrak.objects.AbstractSatellite;
//import jsattrak.objects.GroundStation;
//import jsattrak.objects.SatelliteTleSGP4;
//import name.gano.astro.time.Time;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.Hashtable;
//
///**
// * @author mohammad
// * @version 1.0
// * @since it-1
// */
//public class Main {
//
//    public static void main(final String args[]) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    JSatTrak jSatTrak = new JSatTrak();
//                    Time currentJulianDate = jSatTrak.getCurrentJulianDate();
//                    Hashtable<String, AbstractSatellite> satHash = new Hashtable<>();
//                    Hashtable<String, GroundStation> gsHash = new Hashtable<>();
//
//                    SatelliteTleSGP4 prop = new SatelliteTleSGP4("NOAA 19 [+]",
//                            "1 25544U 98067A   16287.25954678  .00009247  00000-0  14643-3 0  9993",
//                            "2 25544  51.6442 189.1084 0006982  67.1066  83.8420 15.54178804 23357");
//
//                    satHash.put("NOAA 19 [+]", prop);
//                    prop.propogate2JulDate( jSatTrak.getCurrentJulTime() );
//
//                    JDialog iframe = new JDialog(jSatTrak, "test", false);
//                    J3DEarthPanel newPanel = new J3DEarthPanel(iframe, satHash, gsHash, currentJulianDate.getMJD(), jSatTrak);
//                    System.out.println("2");
//                    iframe.setContentPane(newPanel);
//                    iframe.setSize(400, 350);
//                    Point p = jSatTrak.getLocation();
//                    iframe.setLocation(p.x + 15, p.y + 95);
//
//                    iframe.setVisible(true);
//
//                } catch (Exception ignored) {
//                    ignored.printStackTrace();
//                }
//
//            }
//        });
//    }
//
//}
