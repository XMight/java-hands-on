package com.busmac.hashcode;

import com.busmac.models.Planet;

import java.util.HashMap;
import java.util.Map;

public class HashCodeExamples implements Runnable {

    final String EARTH = "Earth";

    @Override
    public void run() {
        byte num1 = 8;
        byte num2 = -8;

        System.out.println(num1 >>> 1);
        System.out.println(num2 >>> 1);
        System.out.println(num2 >> 1);

        Planet earth1 = new Planet(EARTH);
        Planet earth2 = new Planet(EARTH);
        PlanetWithBadHashCode earth3 = new PlanetWithBadHashCode(EARTH);
        PlanetWithBadHashCode earth4 = new PlanetWithBadHashCode(EARTH);
        PlanetWithBadHashCodeAndEquals earth5 = new PlanetWithBadHashCodeAndEquals(EARTH);
        PlanetWithBadHashCodeAndEquals earth6 = new PlanetWithBadHashCodeAndEquals(EARTH);

        Map<Planet, String> mapWithNormalPlanets = new HashMap<>();
        mapWithNormalPlanets.put(earth1, earth1.toString());
        mapWithNormalPlanets.put(earth2, earth2.toString());

        // The size is 2 and the HashMap will probably calculate a different index for each Planet
        System.out.println("mapWithNormalPlanets has size  " + mapWithNormalPlanets.size());

        Map<Planet, String> mapWithPlanetsWithBadHashCode = new HashMap<>();
        mapWithPlanetsWithBadHashCode.put(earth3, earth3.toString());
        mapWithPlanetsWithBadHashCode.put(earth4, earth4.toString());

        // The size is 2 because, even if hashCode returns equal value for these 2 planets, equals will return false.
        // This means that these 2 planets will be located under the same index in the map, connected through linked list nodes
        // This also means that the retrieval of earth4 will not be O(1) because the algorithm must find which of the
        // nodes contain a Key which is equal to earth4 by iterating the LinkedList or the self-balanced binary search tree after
        // a specific threshold
        System.out.println("mapWithPlanetsWithBadHashCode has size  " + mapWithPlanetsWithBadHashCode.size());

        Map<Planet, String> mapWithPlanetsWithBadHashCodeAndEquals = new HashMap<>();
        mapWithPlanetsWithBadHashCodeAndEquals.put(earth5, earth5.toString());
        mapWithPlanetsWithBadHashCodeAndEquals.put(earth6, earth6.toString());

        // The size is 1 because we have bad hashCode and equals, and the earth5 will be overridden by earth6
        System.out.println("mapWithPlanetsWithBadHashCodeAndEquals has size  " + mapWithPlanetsWithBadHashCodeAndEquals.size());
    }
}
