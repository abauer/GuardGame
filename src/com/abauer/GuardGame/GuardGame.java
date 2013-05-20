package com.abauer.GuardGame;

import java.awt.Dimension;
import java.awt.Font;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import com.abauer.GuardGame.data.Commands;
import com.abauer.GuardGame.data.Constants;
import com.abauer.GuardGame.data.GameState;
import com.jpii.gamekit.GameKit;
import com.jpii.gamekit.debug.Debugger;
import com.jpii.gamekit.exception.InvalidApiLevelException;
import com.jpii.gamekit.gui.WindowHandler;
import com.roketgamer.RoketGamer;

public class GuardGame {
	
	private static Debugger debugInstance;
	private static WindowHandler windowHandler;
	private static GameState gameState;
	private static RoketGamer roketGamer;
	
	public static void main(String args[]){
		try {
			GameKit.checkVersion(Constants.GAMEKIT_MIN_API_LEVEL, Constants.GAMEKIT_MAX_API_LEVEL);
		} catch (InvalidApiLevelException e) {
			e.printStackTrace();
		}
	
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		    	onShutdown();
		    }
		}));
		
		setDefaultLookAndFeel();
		debugInstance = new Debugger("NavalBattle");
		debugInstance.registerCommands(Commands.COMMANDS);
		
		if(Constants.DEBUG_MODE)
			debugInstance.showDebugWindow();
		
		gameState = new GameState();
		roketGamer = new RoketGamer();
		
		getDebugWindow().printInfo("NavalBattle " + Constants.GUARDGAME_VERSION + " initialized");
		getDebugWindow().printInfo("Successfully loaded GameKit " + GameKit.getVersion() + " (API " + GameKit.getApiLevel() + ")");
		
		windowHandler = new WindowHandler(492,340);
	
	}
	
	public static void onShutdown() {
		System.out.println("Game is closing.");
		try {
			Thread.sleep(250);
		} catch (Throwable t) { } 
	}
	
	/**
	 * Returns current instance of DebugWindow.
	 * @return debugWindow
	 */
	public static Debugger getDebugWindow() {
		return debugInstance;
	}
	
	/**
	 * Returns current instance of RoketGamer.
	 * @return roketGamer
	 */
	public static RoketGamer getRoketGamer() {
		return roketGamer;
	}
	
	/**
	 * Returns current instance of WindowHandler. Used to switch Windows.
	 * @return windowHandler
	 */
	public static WindowHandler getWindowHandler() {
		return windowHandler;
	}
	
	/**
	 * Returns current instance of GameState.
	 * @return gameState
	 */
	public static GameState getGameState() {
		return gameState;
	}
	
	/**
	 * Attempt to set <code>DefaultLookAndFeel</code> to Nimbus and
	 * alert the users if the process fails.
	 */
	private static void setDefaultLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, unsuported");
			criticalError(e);
		} catch (ClassNotFoundException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, class not found");
			criticalError(e);
		} catch (InstantiationException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, instantiation");
			criticalError(e);
		} catch (IllegalAccessException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, illegalaccess");
			criticalError(e);
		} catch (Exception e) {
			getDebugWindow().printError("NimbusLookAndFeel has encountered an error, " + e.getMessage());
			criticalError(e);
		} catch (Error e) {
			getDebugWindow().printError("NimbusLookAndFeel has encountered an error, " + e.getMessage());
			criticalError(e);
		} catch (Throwable thr) {
			getDebugWindow().printError("NimbusLookAndFeel has encountered an error, " + thr.getMessage());
			criticalError(thr);
		}
	}
	
	/**
	 * Global method in the event of something terrible. Reports the exception to the user for bug reporting.
	 * @param thr
	 */
	public static void criticalError(Throwable thr) {
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sans-Serif", Font.PLAIN, 10));
		textArea.setEditable(false);
		StringWriter writer = new StringWriter();
		thr.printStackTrace(new PrintWriter(writer));
		textArea.setText(Constants.CRITICAL_ERROR_HEADER + writer.toString());

		JScrollPane scrollPane = new JScrollPane(textArea);		
		scrollPane.setPreferredSize(new Dimension(350, 150));

		JOptionPane.showMessageDialog(new JFrame(), scrollPane, "Critical Error", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
}
