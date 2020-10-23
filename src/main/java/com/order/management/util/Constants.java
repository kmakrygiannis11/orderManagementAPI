package com.order.management.util;

public class Constants {

	public static final String ENTITY_TABLE_PREFIX = "TW_";

	public static enum Role {
		ADMIN(0), CASHIER(1), WAITER(2);

		private final int value;

		Role(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
