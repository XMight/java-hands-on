package com.busmac.cloning;

import com.busmac.models.Planet;
import com.busmac.models.SolarSystem;

import java.util.HashMap;
import java.util.Map;

public class CloningExamples implements Runnable {
    @Override
    public void run() {
        Planet p1 = new Planet("Earth");
        Planet p2 = new Planet("Earth");

        Map<Planet, String> m = new HashMap<>();
        m.put(p1, "1");
        m.put(p2, "2");

        SolarSystem ss = new SolarSystem();
        ss.addPlanet(new Planet("Earth"));
        System.out.println(ss);

        try {
            SolarSystem clonedSS = (SolarSystem)ss.clone();
            System.out.println(clonedSS);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
