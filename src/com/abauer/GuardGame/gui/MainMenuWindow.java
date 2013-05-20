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

import javax.swing.*;

import com.abauer.GuardGame.GuardGame;
import com.abauer.GuardGame.Listeners.WindowCloser;
import com.abauer.GuardGame.data.Constants;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuWindow extends BaseWindow {
	private static final long serialVersionUID = 1L;
	JButton btnRoketGamer;

	/**
	 * <code>MainMenuWindow</code> constructor.
	 */
	public MainMenuWindow() {
		super();

		getContentPane().setLayout(null);

		JLabel lblVersion = new JLabel(Constants.GUARDGAME_VERSION_TITLE);
		lblVersion.setForeground(Color.WHITE);
		JLabel lblNavalBattle = new JLabel("Guard Game");
		JButton btnSingleplayer = new JButton("Game");
		btnRoketGamer = new JButton("RoketGamer");
		JButton btnQuit = new JButton("Quit");
		JButton btnCredits = new JButton("Credits");

		lblNavalBattle.setBounds(10, 13, 466, 51);
		lblVersion.setBounds(10, 287, 238, 14);
		btnSingleplayer.setBounds(194, 74, 100, 30);
		btnRoketGamer.setBounds(194, 175, 100, 30);
		btnQuit.setBounds(194, 209, 100, 30);
		btnCredits.setBounds(375, 267, 100, 30);

		lblNavalBattle.setForeground(Color.WHITE);
		lblNavalBattle.setFont(new Font("Verdana",Font.BOLD,36));
		lblNavalBattle.setHorizontalAlignment(SwingConstants.CENTER);

		getContentPane().add(lblVersion);
		getContentPane().add(lblNavalBattle);
		getContentPane().add(btnSingleplayer);
		getContentPane().add(btnRoketGamer);
		getContentPane().add(btnQuit);
		getContentPane().add(btnCredits);

		btnSingleplayer.setFocusable(false);
		btnRoketGamer.setFocusable(false);
		btnQuit.setFocusable(false);
		btnCredits.setFocusable(false);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/com/abauer/GuardGame/res/menu_background.png")));
		label.setBounds(-83, -62, 569, 374);
		getContentPane().add(label);

		btnSingleplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		});	

		btnRoketGamer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		btnQuit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				WindowCloser.close();
			}
		});

		btnCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextWindow("CreditsWindow");
			}
		});
	}

	private static final String PATTERN = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public static boolean validate(final String ip) {          
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();             
	}

	/**
	 * Set visible.
	 */
	public void setVisible(boolean visible){
		super.setVisible(visible);
		if(isVisible()){
			if(GuardGame.getGameState().isOffline()) {
				btnRoketGamer.setEnabled(false);
			}
		}
	}
}