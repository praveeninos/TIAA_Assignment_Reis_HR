package com.tiaa.assign;

import java.util.Objects;

public class Machine implements RawMaterial {
    private Long id;

    public Machine(Long id) {
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
        return "Machine{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return Objects.equals(id, machine.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
