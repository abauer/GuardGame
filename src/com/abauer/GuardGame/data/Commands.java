/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.abauer.GuardGame.data;

import java.util.ArrayList;

import com.abauer.GuardGame.GuardGame;
import com.abauer.GuardGame.Listeners.WindowCloser;
import com.jpii.gamekit.GameKit;
import com.jpii.gamekit.debug.*;

public class Commands {
	
	/**
	 * Commands loaded on game start
	 */
	@SuppressWarnings("serial")
	public static final ArrayList<Command> COMMANDS = new ArrayList<Command>() {{
	    
	    add(new Command("quit", "", "Quit game", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		WindowCloser.close();
	    	}}
	    ));
	    
	    add(new Command("version", "", "View version info", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		GuardGame.getDebugWindow().println(Constants.GUARDGAME_VERSION_TITLE + " (" + Constants.VERSION_CODE + ")");
	    	}}
	    ));
	    
	    add(new Command("credits", "", "NavalBattle credits", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		GuardGame.getDebugWindow().println("----------------- NavalBattle Credits -----------------");
	    		GuardGame.getDebugWindow().println("Anthony \"abauer\" Bauer - Game Design Lead");
	    		GuardGame.getDebugWindow().println("Thomas \"TexasGamer\" Gaubert - RoketGamer lead");
	    		GuardGame.getDebugWindow().println("");
	    		GuardGame.getDebugWindow().println("GitHub - source code hosting");
	    		GuardGame.getDebugWindow().println("RoketGamer - online social gaming");
	    	}}
	    ));
	    
	    add(new Command("rginfo", "", "Get RoketGamer info", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		GuardGame.getDebugWindow().println("RoketGamer " + GuardGame.getRoketGamer().getVersion());
	    		GuardGame.getDebugWindow().println("Server: " + GuardGame.getRoketGamer().getServerLocation());
	    		GuardGame.getDebugWindow().println("Auth status: " + GuardGame.getRoketGamer().getStatus());
	    	}}
	    ));
	    
	    add(new Command("gamekitinfo", "", "Get GameKit info", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		GuardGame.getDebugWindow().println("GameKit " + GameKit.getVersion());
	    		GuardGame.getDebugWindow().println("API level: " + GameKit.getApiLevel());
	    	}}
	    ));
	}};
}