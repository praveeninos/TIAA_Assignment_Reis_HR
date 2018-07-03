package com.tiaa.assign;

import java.util.Objects;

public class Bolt implements RawMaterial {
    private Long id;

    public Bolt(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public String toString() {
        return "Bolt{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bolt bolt = (Bolt) o;
        return Objects.equals(id, bolt.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
