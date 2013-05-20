package com.abauer.GuardGame.data;

import com.abauer.GuardGame.GuardGame;
import com.roketgamer.log.LoggerHook;

public class RoketGamerLogHook extends LoggerHook {

	/**
	 * Prints an informative message.
	 * @param message
	 */
	public void printInfo(String message) {
		GuardGame.getDebugWindow().printInfo(message);
	}

	/**
	 * Prints a warning message.
	 * @param message
	 */
	public void printWarning(String message) {
		GuardGame.getDebugWindow().printWarning(message);
	}

	/**
	 * Prints an error message.
	 * @param message
	 */
	public void printError(String message) {
		GuardGame.getDebugWindow().printError(message);
	}

	/**
	 * Prints other messages.
	 * @param message
	 */
	public void printOther(String message) {
		GuardGame.getDebugWindow().printOther(message);
	}
}
