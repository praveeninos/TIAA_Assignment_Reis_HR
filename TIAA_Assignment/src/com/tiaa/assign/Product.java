package com.tiaa.assign;

import java.util.Objects;

public class Product {
    private RawMaterial firstBolt;
    private RawMaterial machine;
    private RawMaterial secondBolt;
    private boolean readyToAssemble;

    public void assemble() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Product Assembled by ------------");
        firstBolt = null;
        secondBolt = null;
        machine = null;
        readyToAssemble = false;
    }

    public void setFirstBolt(RawMaterial firstBolt) {
        Objects.nonNull(firstBolt);
        this.firstBolt = firstBolt;
        if (secondBolt != null && machine != null) {
            readyToAssemble = true;
            assemble();
        }
    }

    public void setMachine(RawMaterial machine) {
        Objects.nonNull(machine);
        this.machine = machine;
        if (firstBolt != null && secondBolt != null) {
            readyToAssemble = true;
            assemble();
        }
    }

    public void setSecondBolt(RawMaterial secondBolt) {
        Objects.nonNull(secondBolt);
        this.secondBolt = secondBolt;
        if (firstBolt != null && machine != null) {
            readyToAssemble = true;
            assemble();
        }
    }

    public RawMaterial getFirstBolt() {
        return firstBolt;
    }

    public RawMaterial getMachine() {
        return machine;
    }

    public RawMaterial getSecondBolt() {
        return secondBolt;
    }

    public boolean isReadyToAssemble() {
        return readyToAssemble;
    }
}
