package com.order.management.domain;

public enum Category {

	DESSERTS(0), BEVERAGES(2), APPETISERS(3), SALADS(4), BREAKFAST(5), MAIN(6);

	private final int value;

	private Category(int value) {
		this.value = value;
	}

	public int getCategoryValue() {
		return this.value;
	}
}
