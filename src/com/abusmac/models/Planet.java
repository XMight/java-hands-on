package com.abusmac.models;

import com.abusmac.utils.IdGenerator;

import java.util.Objects;

public class Planet {
    protected final int id;
    protected final String name;

    public Planet(String name) {
        this.id = IdGenerator.getNextId();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
