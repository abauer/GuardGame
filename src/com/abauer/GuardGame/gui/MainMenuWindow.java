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
import com.abauer.GuardGame.turn.*;
import com.abauer.GuardGame.util.URLUtils;

import java.awt.*;
import java.awt.event.*;

public class MainMenuWindow extends BaseWindow {
	private static final long serialVersionUID = 1L;
	JButton btnRoketGamer;

	public MainMenuWindow() {
		getContentPane().setLayout(null);
		
		JLabel lblVersion = new JLabel(Constants.GUARDGAME_VERSION_TITLE);
		lblVersion.setForeground(Color.WHITE);
		
		btnRoketGamer = new JButton("RoketGamer");
		btnRoketGamer.setBounds(73, 260, 100, 30);
		getContentPane().add(btnRoketGamer);
		btnRoketGamer.setFocusable(false);
		
		JButton btnClose = new JButton("Quit");
		btnClose.setBounds(324, 260, 90, 30);
		getContentPane().add(btnClose);
		btnClose.setFocusable(false);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(201, 260, 90, 30);
		getContentPane().add(btnCredits);
		btnCredits.setFocusable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 492, 250);
		getContentPane().add(tabbedPane);
		
		JPanel newGames = new JPanel();
		tabbedPane.addTab("New Game", null, newGames, null);
		newGames.setLayout(null);
		
		JButton vAI = new JButton("2 Player Game with AI");
		vAI.setBounds(43, 10, 160, 30);
		newGames.add(vAI);
		vAI.setFocusable(false);
		
		JButton v2AI = new JButton("3 Player Game with AI's");
		v2AI.setBounds(43, 50, 160, 30);
		newGames.add(v2AI);
		v2AI.setFocusable(false);
		
		JButton lan2 = new JButton("2 Player LAN Game");
		lan2.setBounds(43, 90, 160, 30);
		newGames.add(lan2);
		lan2.setFocusable(false);
		
		JButton lan3ai = new JButton("3 Player LAN Game one AI");
		lan3ai.setFont(new Font("SansSerif",Font.PLAIN,10));
		lan3ai.setBounds(43, 130, 160, 30);
		newGames.add(lan3ai);
		lan3ai.setFocusable(false);
		
		JButton lan3 = new JButton("3 Player LAN Game");
		lan3.setBounds(43, 170, 160, 30);
		newGames.add(lan3);
		lan3.setFocusable(false);
		
		JButton on2 = new JButton("2 Player Online Game");
		on2.setBounds(289, 30, 160, 30);
		newGames.add(on2);
		on2.setFocusable(false);
		
		JButton on3 = new JButton("3 Player Online Game");
		on3.setBounds(289, 90, 160, 30);
		newGames.add(on3);
		on3.setFocusable(false);
		
		JButton on2ai = new JButton("3 Player Online one AI");
		on2ai.setBounds(289, 150, 160, 30);
		newGames.add(on2ai);
		on2ai.setFocusable(false);
		
		lan2.setEnabled(false);
		lan3.setEnabled(false);
		lan3ai.setEnabled(false);
		on2.setEnabled(false);
		on3.setEnabled(false);
		on2ai.setEnabled(false);
		
		if(GuardGame.getGameState().isOffline()){
			btnRoketGamer.setEnabled(false);
		}
		
		JPanel history = new JPanel();
		tabbedPane.addTab("Game History", null, history, null);
		history.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/com/abauer/GuardGame/res/menu_background.png")));
		label.setBounds(-83, -62, 569, 374);
		getContentPane().add(label);
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/com/abauer/GuardGame/res/menu_background.png")));
		background.setBounds(-83, -62, 569, 374);
		newGames.add(background);
		
		vAI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GameWindow(new TurnManager(new Human(),new AI()));
				nextWindow("GameWindow");
			}
		});
		
		v2AI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GameWindow(new TurnManager(new Human(),new AI(),new AI()));
				nextWindow("GameWindow");
			}
		});
		
		btnRoketGamer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnRoketGamer.isEnabled())
					URLUtils.openURL("http://jpii.github.io/NavalBattle/help.html");
			}
		});

		btnClose.addMouseListener(new MouseAdapter() {
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
}
