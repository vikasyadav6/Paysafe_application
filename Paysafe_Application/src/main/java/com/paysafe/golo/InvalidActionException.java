package com.paysafe.golo;

public class InvalidActionException extends RuntimeException {

	public InvalidActionException(String message) {
		super(" Invalid request action:" + message + ". Action should be 'start' or 'stop'");
	}
}
