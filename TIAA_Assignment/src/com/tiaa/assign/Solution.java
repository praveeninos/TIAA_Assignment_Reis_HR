package com.tiaa.assign;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	private ConveyorBelt conveyorBelt;
	private Callable<Product> workers[];

	public Solution(ConveyorBelt conveyorBelt, Callable<Product>[] workers) {
		this.conveyorBelt = conveyorBelt;
		this.workers = workers;
	}

	public Long calculateTime() {
		Long startTime = System.currentTimeMillis();
		ExecutorService e = Executors.newFixedThreadPool(workers.length);
		Collection<Callable<Product>> collect = Arrays.stream(workers).collect(Collectors.toList());
		List<Future<Product>> futures = null;
		try {
			do {
				futures = e.invokeAll(collect);
				System.out.println("Workers Done - " + futures.stream().filter(Future::isDone).count());
			} while (conveyorBelt.isRawMaterialAvailable());

		} catch (InterruptedException e1) {
			return 0L;
		}
		e.shutdown();
		return System.currentTimeMillis() - startTime;
	}

	public static void main(String[] args) {
		ConveyorBelt belt = new ConveyorBelt(createNBolts(6), createNMachines(3));
		belt.fillBelt();

		Solution solution = new Solution(belt,
				new Callable[] { new Worker(belt, "AA"), new Worker(belt, "BB"), new Worker(belt, "CC") });
		System.out.println("Total Time calculated - " + solution.calculateTime());

	}

	private static List<RawMaterial> createNBolts(int numberOfBolts) {
		return IntStream.range(1, numberOfBolts + 1).mapToObj(value -> new Bolt((long) value))
				.collect(Collectors.toList());
	}

	private static List<RawMaterial> createNMachines(int numberOfMachines) {
		return IntStream.range(1, numberOfMachines + 1).mapToObj(value -> new Machine((long) value))
				.collect(Collectors.toList());
	}
}
