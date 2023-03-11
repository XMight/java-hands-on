package com.busmac.hashcode;

import com.busmac.models.Planet;

public class PlanetWithBadHashCodeAndEquals extends PlanetWithBadHashCode {
    public PlanetWithBadHashCodeAndEquals(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return name.equals(planet.getName());
    }
}
