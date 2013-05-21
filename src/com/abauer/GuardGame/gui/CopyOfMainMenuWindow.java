//
//		
//
//		lblNavalBattle.setBounds(10, 13, 466, 51);
//		lblVersion.setBounds(10, 287, 238, 14);
//		btnSingleplayer.setBounds(194, 74, 100, 30);
//		btnRoketGamer.setBounds(194, 175, 100, 30);
//		btnQuit.setBounds(194, 209, 100, 30);
//		btnCredits.setBounds(375, 267, 100, 30);
//
//		lblNavalBattle.setForeground(Color.WHITE);
//		lblNavalBattle.setFont(new Font("Verdana",Font.BOLD,36));
//		lblNavalBattle.setHorizontalAlignment(SwingConstants.CENTER);
//
//		getContentPane().add(lblVersion);
//		getContentPane().add(lblNavalBattle);
//		getContentPane().add(btnSingleplayer);
//		getContentPane().add(btnRoketGamer);
//		getContentPane().add(btnQuit);
//		getContentPane().add(btnCredits);
//
//		btnSingleplayer.setFocusable(false);
//		btnRoketGamer.setFocusable(false);
//		btnQuit.setFocusable(false);
//		btnCredits.setFocusable(false);
//		
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(CopyOfMainMenuWindow.class.getResource("/com/abauer/GuardGame/res/menu_background.png")));
//		label.setBounds(-83, -62, 569, 374);
//		getContentPane().add(label);
//
//		btnSingleplayer.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//			
//			}
//		});	
//
//		btnRoketGamer.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if(btnRoketGamer.isEnabled())
//					URLUtils.openURL("http://jpii.github.io/NavalBattle/help.html");
//			}
//		});
//
//		btnQuit.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				WindowCloser.close();
//			}
//		});
//
//		btnCredits.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				nextWindow("CreditsWindow");
//			}
//		});
//	}
//
//	private static final String PATTERN = 
//			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
//
//	public static boolean validate(final String ip) {          
//		Pattern pattern = Pattern.compile(PATTERN);
//		Matcher matcher = pattern.matcher(ip);
//		return matcher.matches();             
//	}
//
//	/**
//	 * Set visible.
//	 */
//	public void setVisible(boolean visible){
//		super.setVisible(visible);
//		if(isVisible()){
//			if(GuardGame.getGameState().isOffline()) {
//				btnRoketGamer.setEnabled(false);
//			}
//		}
//	}
//}