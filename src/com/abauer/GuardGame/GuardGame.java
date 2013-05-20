package com.abauer.GuardGame;

import com.jpii.gamekit.debug.Debugger;

public class GuardGame {
	
	private static Debugger debugInstance;
	
	public static void main(String args[]){
		System.out.println("Hello World");
	}
	
	/**
	 * Returns current instance of DebugWindow.
	 * @return debugWindow
	 */
	public static Debugger getDebugWindow() {
		return debugInstance;
	}
	
}
