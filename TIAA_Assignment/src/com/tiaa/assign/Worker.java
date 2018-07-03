package com.tiaa.assign;

import java.util.concurrent.Callable;

public class Worker implements Callable<Product> {
	private String workerName;
	private ConveyorBelt belt;
	private Product product;

	public Worker(ConveyorBelt belt, String name) {
		this.belt = belt;
		this.workerName = name;
		product = new Product();
	}

	@Override
	public Product call() {
		RawMaterial pick = belt.pick();
		System.out.println(workerName + " picked " + pick.getName());
		if (pick instanceof Bolt && product.getFirstBolt() == null) {
			product.setFirstBolt(pick);
		} else if (pick instanceof Bolt && product.getSecondBolt() == null) {
			product.setSecondBolt(pick);
		} else if (pick instanceof Machine && product.getMachine() == null) {
			product.setMachine(pick);
		} else {
			belt.putBack(pick);
		}
		return null;
	}

}
