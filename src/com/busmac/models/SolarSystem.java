package com.busmac.models;

import com.busmac.utils.IdGenerator;

import java.util.HashSet;
import java.util.Set;

public class SolarSystem implements Cloneable {
    private final int id;
    private final Set<Planet> planets;
    private final Set<Star> stars;

    public SolarSystem() {
        id = IdGenerator.getNextId();
        planets = new HashSet<>();
        stars = new HashSet<>();
    }

    public boolean addStar(Star star) {
        return stars.add(star);
    }

    public boolean addPlanet(Planet planet) {
        return planets.add(planet);
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "id=" + id +
                ", planets=" + planets +
                ", stars=" + stars +
                '}' + this.hashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
