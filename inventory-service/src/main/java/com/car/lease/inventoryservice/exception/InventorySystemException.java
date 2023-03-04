package com.car.lease.inventoryservice.exception;

public class InventorySystemException extends RuntimeException{
	
	private static final long serialVersionUID = 5861310537366287163L;

	public InventorySystemException() {
		super();
	}

	public InventorySystemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InventorySystemException(final String message) {
		super(message);
	}

	public InventorySystemException(final Throwable cause) {
		super(cause);
	}

}
