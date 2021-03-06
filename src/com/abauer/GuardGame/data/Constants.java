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

import com.abauer.GuardGame.Listeners.KeyboardListener;
import com.abauer.GuardGame.Listeners.WindowCloser;


public class Constants {
	
	/*
	 * General
	 */
	public static final String GUARDGAME_VERSION = "0.0.1";
	public static final String VERSION_CODE = "1";
	public static final String GUARDGAME_CODENAME = "3s";
	public static final String GUARDGAME_VERSION_TITLE = "GuardGame " + GUARDGAME_VERSION + " (" + GUARDGAME_CODENAME + ")";
	public static final String CRITICAL_ERROR_HEADER = "GuardGame encountered a critical error and must close.\n" +
			"Report the error to: anthonyambauer@gmail.com";
	
	public static final boolean DEBUG_MODE = true;
	
	public static final int SPLASH_DURATION = 1000;
	public static final int SPLASH_SCREEN_TIMEOUT = 000;
	
	public static final KeyboardListener keys = new KeyboardListener();
	public static final WindowCloser closer = new WindowCloser();
	
	/*
	 * Game engine
	 */
	
	/*
	 * Gameplay
	 */
	
	/*
	 * RoketGamer
	 */
	public static final String API_KEY = "";
	public static final RoketGamerLogHook ROKETGAMER_LOG_HOOK = new RoketGamerLogHook();
	
	/*
	 * GameKit
	 */
	public static final int GAMEKIT_MAX_API_LEVEL = 1;
	public static final int GAMEKIT_MIN_API_LEVEL = 0;
}