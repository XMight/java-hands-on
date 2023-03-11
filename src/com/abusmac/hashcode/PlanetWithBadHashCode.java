package com.abusmac.hashcode;

import com.abusmac.models.Planet;

public class PlanetWithBadHashCode extends Planet {
    public PlanetWithBadHashCode(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.getId() && name.equals(planet.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
