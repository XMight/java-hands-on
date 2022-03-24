package com.busmac.models;

public class PlanetWithBadHashCode extends Planet {
    public PlanetWithBadHashCode(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id && name.equals(planet.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
