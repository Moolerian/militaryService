package util;

import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.*;
import gov.nasa.worldwindx.examples.util.BalloonController;
import gov.nasa.worldwindx.examples.util.HotSpotController;
import model.Facility;

import java.util.ArrayList;

import static util.Constants.iranLat;
import static util.Constants.iranLon;

/**
 * Created by Mohammad on 9/16/2016.
 */
public class WWJUtil {

    private static WorldWindowGLJPanel wwj;
    private static ArrayList<Facility> userFacilities = new ArrayList<>();

    private static Layer worldMapLayer;
    private static Layer compassLayer;
    private static Layer scaleLayer;
    private static Layer placeNameLayer;
    private static Layer openStreetLayer;

    public static void createWWJ() {
        wwj = new WorldWindowGLJPanel();
        Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
        wwj.setModel(m);

        worldMapLayer = wwj.getModel().getLayers().getLayerByName("World Map");
        wwj.getModel().getLayers().remove(worldMapLayer);
        compassLayer = wwj.getModel().getLayers().getLayerByName("Compass");
        wwj.getModel().getLayers().remove(compassLayer);
        scaleLayer = wwj.getModel().getLayers().getLayerByName("Scale bar");
        wwj.getModel().getLayers().remove(scaleLayer);
        placeNameLayer = wwj.getModel().getLayers().getLayerByName("Place Names");
        wwj.getModel().getLayers().remove(placeNameLayer);
        openStreetLayer = wwj.getModel().getLayers().getLayerByName("Open Street Map");
        wwj.getModel().getLayers().add(openStreetLayer);
    }

    public static void addFacilityToEarth(Facility facility) {
        new HotSpotController(wwj);
        new BalloonController(wwj);
        Position position;
        String balloonText;
        if (facility.getLatitude() == null || facility.getLongitude() == null) {
            position = new Position(LatLon.fromDegrees(iranLat, iranLon), 0d);
            balloonText = "name :  " + facility.getDisplayName() + "lat: " + iranLat + " lon : " + iranLon +
                    " width: " + " not-defined" + " Length: " + "not-defined";
        } else {
            position = new Position(LatLon.fromDegrees(facility.getLatitude(), facility.getLongitude()), 0d);
            balloonText = "name :  " + facility.getDisplayName() + "lat: " + facility.getLatitude() + " lon : "
                    + facility.getLongitude() ;
        }

        AbstractBrowserBalloon balloon = new GlobeBrowserBalloon("", position);
        balloon.setDrawTitleBar(false);
        balloon.setVisible(false);
        balloon.setDrawBrowserControls(false);
        balloon.setText(balloonText);

        BalloonAttributes attrs = new BasicBalloonAttributes();
        Size size = new Size();
        size.setHeight("", 120, "");
        size.setWidth("", 650, "");
        attrs.setSize(size);
        balloon.setAttributes(attrs);

        PointPlacemark placemark = new PointPlacemark(position);
        placemark.setLabelText("\u202B" + facility.getDisplayName());
        placemark.setValue(AVKey.BALLOON, balloon);

        RenderableLayer layer = new RenderableLayer();
        layer.setName(facility.getId().toString());
        layer.addRenderable(balloon);
        layer.addRenderable(placemark);

        Layer facilityLayer = wwj.getModel().getLayers().getLayerByName(facility.getId().toString());
        if (facilityLayer != null) {
            wwj.getModel().getLayers().remove(facilityLayer);
        }
        wwj.getModel().getLayers().add(layer);
    }

    public static WorldWindowGLJPanel getWwj() {
        return wwj;
    }

    public static void setWwj(WorldWindowGLJPanel wwj) {
        WWJUtil.wwj = wwj;
    }

    public static Layer getWorldMapLayer() {
        return worldMapLayer;
    }

    public static void setWorldMapLayer(Layer worldMapLayer) {
        WWJUtil.worldMapLayer = worldMapLayer;
    }

    public static Layer getCompassLayer() {
        return compassLayer;
    }

    public static void setCompassLayer(Layer compassLayer) {
        WWJUtil.compassLayer = compassLayer;
    }

    public static Layer getScaleLayer() {
        return scaleLayer;
    }

    public static void setScaleLayer(Layer scaleLayer) {
        WWJUtil.scaleLayer = scaleLayer;
    }

    public static Layer getPlaceNameLayer() {
        return placeNameLayer;
    }

    public static void setPlaceNameLayer(Layer placeNameLayer) {
        WWJUtil.placeNameLayer = placeNameLayer;
    }

    public static Layer getOpenStreetLayer() {
        return openStreetLayer;
    }

    public static void setOpenStreetLayer(Layer openStreetLayer) {
        WWJUtil.openStreetLayer = openStreetLayer;
    }

    public static ArrayList<Facility> getUserFacilities() {
        return userFacilities;
    }

    public static void setUserFacilities(ArrayList<Facility> userFacilities) {
        WWJUtil.userFacilities = userFacilities;
    }
}
