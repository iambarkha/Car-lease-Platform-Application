package com.car.lease.brokerservice.exception;

public class BrokerSystemException extends RuntimeException{
	
	private static final long serialVersionUID = 5861310537366287163L;

	public BrokerSystemException() {
		super();
	}

	public BrokerSystemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public BrokerSystemException(final String message) {
		super(message);
	}

	public BrokerSystemException(final Throwable cause) {
		super(cause);
	}

}
