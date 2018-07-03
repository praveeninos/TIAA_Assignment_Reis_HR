package com.tiaa.assign;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ConveyorBelt {
    private volatile Queue<RawMaterial> rawMaterial;

    public ConveyorBelt(List<RawMaterial> bolts, List<RawMaterial> machines) {
        rawMaterial = new ArrayBlockingQueue<>(100);
        rawMaterial.addAll(machines);
        rawMaterial.addAll(bolts);
    }

    public void fillBelt() {
//        Collections.shuffle(rawMaterial);
    }

    public RawMaterial pick() {
        return rawMaterial.poll();
    }

    public void putBack(RawMaterial material) {
        System.out.println("Return back" + material.getName());
        rawMaterial.offer(material);
    }

    public synchronized boolean isRawMaterialAvailable() {
        return !rawMaterial.isEmpty();
    }
}
