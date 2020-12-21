package pl.ioad1.bauhinia.physics;

import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import net.e175.klaus.solarpositioning.DeltaT;
import net.e175.klaus.solarpositioning.SPA;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pl.ioad1.bauhinia.sessionManager.model.Element;

public class HeatMap {
    ArrayList<String> materialNames;
    ArrayList<Double> materialFactors;

    //do zrobienia: Trzeba brać skądś godzinę. miesiac i dzien chyba mogą byc stałe
    public double SunImpact(Element element) {
        GregorianCalendar dateTime = new GregorianCalendar();
        dateTime.set(Calendar.HOUR_OF_DAY, 13);
        dateTime.set(Calendar.MINUTE, 0);
        dateTime.set(Calendar.MONTH, Calendar.JULY);
        dateTime.set(Calendar.DATE, 15);

        // parametey geograficzne odpowiadoją Łodzi
        AzimuthZenithAngle position = SPA.calculateSolarPosition(
                dateTime,
                51.75, // latitude (degrees)
                19.47, // longitude (degrees)
                190, // elevation (m) [wysokość npm]
                DeltaT.estimate(dateTime), // delta T (s)
                1010, // avg. air pressure (hPa)
                20); // avg. air temperature (°C)

        // obliczenie wysokości cienia
        double h = (element.getHeight()) / (Math.tan(Math.toRadians(90 - position.getZenithAngle())));
        double p = 0;

        if (h > 0) {
            // obliczenie pola powierzchni cienia
            // pole dwóch równoległoboków o wysokości h, i podstawach a*cos(alfa) i b*sin(alfa)
            // alfa to kąt z której strony świeci słońce (azimuth)
            p = Math.abs(h * ((element.getWidth() * Math.cos(Math.toRadians(360 - position.getAzimuth()))) + (element.getLength() * Math.sin(Math.toRadians(360 - position.getAzimuth())))));
        }
        return p;
    }

    public double ElementImpact(Element element) {
        int w = element.getWidth();
        int l = element.getLength();
        float h = element.getHeight();

        /*
        String material = element.getMaterial();
        double f = 0;
        for (int i = 0; i < materialNames.size(); i++) {
            if (material.equals(materialNames.get(i))) {
                f = materialFactors.get(i);
            }
        }
         */
        return w * l * h; //*f
    }

    public void generateHeatMap() {
    }

}