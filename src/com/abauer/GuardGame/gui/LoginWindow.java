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
import java.awt.event.*;

import com.abauer.GuardGame.GuardGame;
import com.abauer.GuardGame.Listeners.Focus;
import com.abauer.GuardGame.data.Constants;
import com.abauer.GuardGame.util.URLUtils;
import com.roketgamer.Player;
import com.roketgamer.rauth.*;

public class LoginWindow extends BaseWindow {
	private static final long serialVersionUID = 1L;
	JButton loginButton;
	JLabel usernameLabel, passwordLabel, lblCheckingForUpdate;
	JTextField usernameField;
	JPasswordField passwordField;

	/**
	 * <code>LoginWindow</code> constructor.
	 */
	public LoginWindow() {
		super(500,190);
		getContentPane().setLayout(null);
		usernameLabel = new JLabel();
		usernameField = new JTextField(25);
		passwordLabel = new JLabel();
		passwordField = new JPasswordField(25);
		loginButton = new JButton("Login");
		JButton registerButton = new JButton("Register");
		JButton offlineButton = new JButton("Offline");
		JLabel lblVersion = new JLabel(Constants.GUARDGAME_VERSION);
		
		usernameLabel.setText("Username");
		passwordLabel.setText("Password");
		passwordLabel.setToolTipText("Use RoketGamer application password");
		passwordField.setToolTipText("Use RoketGamer application password");
		
		usernameLabel.setBounds(295,8,78,30);
		usernameField.setBounds(365,8,113,30);
		passwordLabel.setBounds(295,39,78,30);
		passwordField.setBounds(365,39,113,30);
		loginButton.setBounds(400,81,78,30);
		registerButton.setBounds(400, 113, 78, 30);
		offlineButton.setBounds(315, 81, 78, 30);
		lblVersion.setBounds(7, 139, 193, 14);
		getContentPane().add(usernameLabel);
		getContentPane().add(usernameField);
		getContentPane().add(passwordLabel);
		getContentPane().add(passwordField);
		getContentPane().add(loginButton);
		getContentPane().add(lblVersion);
		getContentPane().add(registerButton);
		getContentPane().add(offlineButton);
		
		loginButton.setFocusable(false);
		registerButton.setFocusable(false);
		offlineButton.setFocusable(false);
		
		passwordField.addKeyListener(Constants.keys);
		usernameField.addKeyListener(Constants.keys);
		
		passwordField.addFocusListener(new Focus(this));
		usernameField.addFocusListener(new Focus(this));
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {				
				login();
			}
		});
		
		offlineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				offlineAction();
			}
		});
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {			
				GuardGame.getDebugWindow().printInfo("Opening register page");
				URLUtils.openURL(GuardGame.getRoketGamer().getServerLocation() + "/register.php?game=1&name=GuardGame");
			}
		});
	}
	
	private String createString(char[] c){
		String temp = "";
		for(int index=0; index<c.length; index++)
			temp+=c[index];
		return temp;
	}
	
	/**
	 *  Method for handling login with RoketGamer.
	 */
	public void login() {
		AuthStatus status = GuardGame.getRoketGamer().init(new APIKey(Constants.API_KEY), 
				new Player(usernameField.getText(), 
				new Password(createString(passwordField.getPassword()))), Constants.ROKETGAMER_LOG_HOOK);
		
		if (status == AuthStatus.GOOD) {
			GuardGame.getDebugWindow().printInfo("User authenticated");
			GuardGame.getDebugWindow().printInfo("Logged in as: " + GuardGame.getRoketGamer().getPlayer().getName());
			GuardGame.getGameState().setOffline(false);
			nextWindow("LoggingInWindow");
			donewithMe();
		} else {
			if(status == AuthStatus.BAD) {
				GuardGame.getDebugWindow().printWarning("Authentication failed: AuthStatus.BAD");	
				JOptionPane.showMessageDialog(this, "Incorrect username or password. \nUse your application password to login.");
			} else if (status == AuthStatus.OFFLINE) {
				GuardGame.getDebugWindow().printWarning("Authentication failed: AuthStatus.OFFLINE");	
				JOptionPane.showMessageDialog(this, "Unable to login. RoketGamer API is offline. Check website.");
			} else if (status == AuthStatus.INVALID_API_KEY) {
				GuardGame.getDebugWindow().printWarning("Authentication failed: AuthStatus.INVALID_API_KEY");	
				JOptionPane.showMessageDialog(this, "Unable to login. API key is invalid.");
			} else if (status == AuthStatus.UNKNOWN) {
				GuardGame.getDebugWindow().printWarning("Authentication failed: AuthStatus.UNKNOWN");	
				JOptionPane.showMessageDialog(this, "Unable to login. Retry later or check the RoketGamer website.");
			} else {
				GuardGame.getDebugWindow().printWarning("Authentication failed: AuthStatus is not recognized.");
				GuardGame.getDebugWindow().printWarning("Internet may be disconnected.");
				JOptionPane.showMessageDialog(this, "Unable to login. Check your internet connection.");
			}
		}
	}
	
	public void offlineAction(){
		GuardGame.getWindowHandler().getToasterManager().showToaster(new ImageIcon(getClass().getResource("/com/roketgamer/res/logo_100px.png")),"Offline mode enabled");
		GuardGame.getDebugWindow().printInfo("Opening in offline mode");
		GuardGame.getDebugWindow().printWarning("RoketGamer disabled");
		GuardGame.getGameState().setOffline(true);
		nextWindow("LoggingInWindow");
		donewithMe();
	}
}