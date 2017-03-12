package test;

import model.Result;
import util.EarthUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author mohammad
 */
public class LinePanel extends JPanel {

    private java.util.List<Result> resultList;

    public void setResultList(java.util.List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int facilityNameX = 500;
        int facilityNameY = 15;
        int calculatingDateY = 15;
        int calculatingDateX = 600;
        int lineY = 70;
        for (Result result : resultList) {

            Font currentFont = g2d.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.2F);
            g2d.setFont(newFont.deriveFont(Font.BOLD));

            g2d.setColor(Color.GREEN);
            g2d.drawRect(0, lineY, 1440, 30);
            g2d.fillRect(0, lineY, 1440, 30);

            g2d.setColor(Color.BLACK);
            g2d.drawString(result.getFacilityName(), facilityNameX, facilityNameY);
            g2d.drawString(EarthUtil.convertJulianToPersian(result.getDate()), calculatingDateX, calculatingDateY);

            java.util.List<int[]> line = result.getLine();
            for (int[] ints : line) {
                g2d.setColor(Color.RED);
                g2d.drawRect(ints[0], lineY, ints[1], 30);
                g2d.fillRect(ints[0], lineY, ints[1], 30);


                g2d.setFont(currentFont.deriveFont(currentFont.getSize() * 0.9F));

                g2d.setColor(Color.BLUE);
                g2d.drawString(intToTime(ints[0]), ints[0], lineY - 30);

                g2d.drawString(String.valueOf(ints[1]), ints[0], lineY - 15);

            }

            g2d.setColor(Color.BLUE);
            g2d.drawRect(0, facilityNameY - 30, 1440, 3);
            g2d.fillRect(0, facilityNameY - 30 , 1440, 3);

            lineY += 140;
            facilityNameY += 145;
            calculatingDateY+=145;
        }

    }

    private String intToTime(int intTime) {
        String time;

        int hour = intTime / 60;
        int minute = intTime % 60;
        time = String.valueOf(hour) + ":" + minute;

        return time;
    }
}
