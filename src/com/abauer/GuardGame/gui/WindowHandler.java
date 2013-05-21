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

package com.abauer.GuardGame.gui;

import com.jpii.gamekit.toaster.Toaster;

public class WindowHandler extends com.jpii.gamekit.gui.WindowHandler{
	
	private static Toaster toasterManager;
	
	public WindowHandler(int defaultx, int defaulty) {
		super(defaultx, defaulty);
		toasterManager = new Toaster();
		new LoginWindow();
		new LoggingInWindow();
		new MainMenuWindow();
		new CreditsWindow();
	}
	
	/**
	 * Returns current instance of <code>Toaster</code>. Used to send desktop notifications.
	 * @return toasterManager
	 */
	public Toaster getToasterManager() {
		return toasterManager;
	}
	
	public BaseWindow getFirstWindow(){
		return (BaseWindow) containedWindows.get(0);
	}
}
