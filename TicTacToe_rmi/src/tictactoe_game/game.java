package tictactoe_game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;

import tictactoe_rmi_gameHandle.gameHandle;
import tictactoe_rmi_gameHandleImpl.gameHandleImpl;
import tictactoe_rmi_gameServer.gameServer;
import tictactoe_rmi_gameSession.gameSession;


@SuppressWarnings("serial")
public class game extends JFrame {
	// Anfang Attribute
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JTextField[] textFelder = new JTextField[9];
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JButton jButton5 = new JButton();
	private JButton jButton6 = new JButton();
	private JButton jButton7 = new JButton();
	private JButton jButton8 = new JButton();
	private JButton jButton9 = new JButton();
	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField11 = new JTextField();
	private JTextField jTextField12 = new JTextField();
	private JTextField jTextField13 = new JTextField();
	private JTextField jTextField14 = new JTextField();
	private JTextField jTextField15 = new JTextField();
	private JTextField jTextField16 = new JTextField();
	private JTextField jTextField17 = new JTextField();
	private JTextField jTextField18 = new JTextField();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField3 = new JTextField();
	private JLabel jLabel3 = new JLabel();
			
	private int[] i = new int[9];

	private int holder = 0;

	private static JTextField jTextField4 = new JTextField();
	private JButton jButton10 = new JButton();
	private gameHandle handle;
	private gameSession session;

	// Ende Attributes


	public game(String name, int portNumber, String nickname) throws MalformedURLException, RemoteException, NotBoundException{
	
		
		// Frame-Initialisierung			
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 321;
		int frameHeight = 319;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Container cp = getContentPane();
		cp.setLayout(null);				
				
				
		// Anfang Komponenten
		for (int j = 0; j < i.length; j++) {
			i[j] = 0;
		}
		jButton1.setBounds(32, 64, 33, 33);
		jButton1.setText("1");
		jButton1.setMargin(new Insets(2, 2, 2, 2));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 1;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton1);
		jButton2.setBounds(72, 64, 33, 33);
		jButton2.setText("2");
		jButton2.setMargin(new Insets(2, 2, 2, 2));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 2;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton2);
		jButton3.setBounds(112, 64, 33, 33);
		jButton3.setText("3");
		jButton3.setMargin(new Insets(2, 2, 2, 2));
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 3;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton3);
		jButton4.setBounds(32, 104, 33, 33);
		jButton4.setText("4");
		jButton4.setMargin(new Insets(2, 2, 2, 2));
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 4;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton4);
		jButton5.setBounds(72, 104, 33, 33);
		jButton5.setText("5");
		jButton5.setMargin(new Insets(2, 2, 2, 2));
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 5;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton5);
		jButton6.setBounds(112, 104, 33, 33);
		jButton6.setText("6");
		jButton6.setMargin(new Insets(2, 2, 2, 2));
		jButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 6;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton6);
		jButton7.setBounds(32, 144, 33, 33);
		jButton7.setText("7");
		jButton7.setMargin(new Insets(2, 2, 2, 2));
		jButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 7;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton7);
		jButton8.setBounds(72, 144, 33, 33);
		jButton8.setText("8");
		jButton8.setMargin(new Insets(2, 2, 2, 2));
		jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 8;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton8);
		jButton9.setBounds(112, 144, 33, 33);
		jButton9.setText("9");
		jButton9.setMargin(new Insets(2, 2, 2, 2));
		jButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				holder = 9;
				try {
					session.jButton_ActionPerformedCS(evt, holder);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton9);
		jTextField1.setBounds(160, 64, 33, 32);
		jTextField1.setText("");
		jTextField1.setEditable(false);
		cp.add(jTextField1);
		textFelder[0] = jTextField1;
		jTextField11.setBounds(200, 64, 33, 32);
		jTextField11.setText("");
		jTextField11.setEditable(false);
		cp.add(jTextField11);
		textFelder[1] = jTextField11;
		jTextField12.setBounds(240, 64, 33, 32);
		jTextField12.setText("");
		jTextField12.setEditable(false);
		cp.add(jTextField12);
		textFelder[2] = jTextField12;
		jTextField13.setBounds(160, 104, 33, 32);
		jTextField13.setText("");
		jTextField13.setEditable(false);
		cp.add(jTextField13);
		textFelder[3] = jTextField13;
		jTextField14.setBounds(200, 104, 33, 32);
		jTextField14.setText("");
		jTextField14.setEditable(false);
		cp.add(jTextField14);
		textFelder[4] = jTextField14;
		jTextField15.setBounds(240, 104, 33, 32);
		jTextField15.setText("");
		jTextField15.setEditable(false);
		cp.add(jTextField15);
		textFelder[5] = jTextField15;
		jTextField16.setBounds(160, 144, 33, 32);
		jTextField16.setText("");
		jTextField16.setEditable(false);
		cp.add(jTextField16);
		textFelder[6] = jTextField16;
		jTextField17.setBounds(200, 144, 33, 32);
		jTextField17.setText("");
		jTextField17.setEditable(false);
		cp.add(jTextField17);
		textFelder[7] = jTextField17;
		jTextField18.setBounds(240, 144, 33, 32);
		jTextField18.setText("");
		jTextField18.setEditable(false);
		cp.add(jTextField18);
		textFelder[8] = jTextField18;
		jLabel1.setBounds(88, 16, 190, 32);
		jLabel1.setText("TIC-TAC-TOE");
		jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 23));
		cp.add(jLabel1);
		jLabel2.setBounds(32, 192, 71, 25);
		jLabel2.setText("Player:");
		jLabel2.setFont(new Font("MS Sans Serif", Font.PLAIN, 18));
		cp.add(jLabel2);
		jTextField2.setBounds(120, 192, 33, 24);
		jTextField2.setText("1");
		jTextField2.setEditable(false);
		cp.add(jTextField2);
		jTextField3.setBounds(120, 224, 33, 24);
		jTextField3.setText("X");
		jTextField3.setEditable(false);
		cp.add(jTextField3);
		jLabel3.setBounds(32, 224, 76, 25);
		jLabel3.setText("Symbol");
		jLabel3.setFont(new Font("MS Sans Serif", Font.PLAIN, 18));
		cp.add(jLabel3);
		jTextField4.setBounds(160, 192, 113, 24);
		jTextField4.setText("");
		jTextField4.setEditable(false);
		cp.add(jTextField4);
		jButton10.setBounds(160, 224, 113, 25);
		jButton10.setText("RESET");
		jButton10.setMargin(new Insets(2, 2, 2, 2));
		jButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					session.jButton10_ActionPerformedCS(evt);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		});
		cp.add(jButton10);
		buttons.add(jButton1);
		buttons.add(jButton2);
		buttons.add(jButton3);
		buttons.add(jButton4);
		buttons.add(jButton5);
		buttons.add(jButton6);
		buttons.add(jButton7);
		buttons.add(jButton8);
		buttons.add(jButton9);
	// Ende Komponenten
		jButton10.setEnabled(false);
		setResizable(false);
		setVisible(true);

	//Anmeldung beim Spieleserver
		gameServer gameServer;	
		gameServer = (gameServer) Naming.lookup("rmi://localhost:" + portNumber +"/gameServer");
		handle = new gameHandleImpl(this);
		session = gameServer.createSession(nickname, handle);
				
			
	}//Konstruktor
	
	
	/**
	 * Setzt die Buttons aktiv/inaktiv, je nachdem
	 * welcher Spieler gerade am Zug ist.
	 * @param active gibt an, ob man selbst aktiv ist oder nicht (true oder false)
	 */
	private void setActive (Boolean active){
		if (active){
			for (int i=0; i < buttons.size(); i++){
				if (textFelder[i].getText().equals("") || textFelder[i].getText()==null){
					buttons.get(i).setEnabled(true);
				} else {
					buttons.get(i).setEnabled(false);
				}
			}
		} else {
			for (JButton button : buttons)
				button.setEnabled(false);
		}
	}// setActive
	
	/**
	 * Setzt das vom Server vorgegebene Zeichen an die vorgegebene Position des Spielfeldes
	 * gibt ausserdem an, wer als naechstes am Zug ist
	 * @param position wo muss das Zeichen hin
	 * @param symbol welches Zeichen muss da hin
	 * @param player wer ist danach aktiv (1 ich, 2 der andere)
	 */
	public void setSign(int position, String symbol, int player) {
		textFelder[(position - 1)].setText(symbol);
		if (player == 1){  
			jTextField4.setText("Your turn");
			
			setActive(true);
		} else {
			jTextField4.setText("Oppenents turn");
			
			setActive(false);
		}
		 if(symbol.equals("X")){
			 jTextField3.setText("O");
			 jTextField2.setText("2");
		 } else {
			 jTextField3.setText("X");
			 jTextField2.setText("1");
		 }
		  buttons.get((position - 1)).setEnabled(false);
	} //setSign
	

	/**
	 * Spielfeld wird zur�ckgesetzt auf Anfang, f�r eine neue Runde
	 * @param player wer f�ngt an (1 ich, 2 der andere)
	 * @param symbol welches symbol ist jetzt dran.
	 */
	public void reset(int player, String symbol) {
		for (int l = 0; l < textFelder.length; l++) {
			textFelder[l].setText("");
		}
		jTextField4.setText("");
		if (player == 1){
			jTextField4.setText("your turn");
			
			setActive(true);
		} else if (player == 2) {
			jTextField4.setText("Opponents turn");
			
			setActive(false);
		} else {
			jTextField4.setText("Please wait for Player 2");
			for (JButton button : buttons)
				button.setEnabled(false);
		}
		jTextField3.setText(symbol);

		
		jButton10.setEnabled(false);
		
	} //reset


	/**
	 * Sperrt die andere Buttons, aktiviert den Reset-Button
	 * und gibt den Gewinner aus (0 unentschieden, 1 ich, 2 der andere)
	 * @param winner wer hat gewonnen
	 */
	public void victory(int winner) {
		if (winner == 1){
			 jTextField4.setText("You win!");
		} else if (winner == 2){
			 jTextField4.setText("Opponent wins!");
		} else {
		 	jTextField4.setText("Draw!");
		}
		jButton10.setEnabled(true); 
		for (JButton button : buttons)
		button.setEnabled(false);
		
	} //victory
	
	/**
	 * nur zu Testzwecken, Spiele erstellen l�uft �ber die Klasse lobby
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new game("tictactoe", 1099, "phil");
			new game("tictactoe2", 1099, "chris");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("Keine Spiele gestartet!");
		}
		
	}// main

}// class game
