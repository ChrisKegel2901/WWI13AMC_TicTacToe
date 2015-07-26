package tictactoe_rmi_client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import tictactoe_rmi_interface.TicTacToe_client;
import tictactoe_rmi_interface.TicTacToe_server;


/**
*
* Dies ist die Client - Klasse des TicTacToe Spiels.
* Sie wird via RMI zum Server verbunden, auf dem die Spielelogik l�uft, 
* der Client stellt nur die GUI und gibt die Eingaben an den Server weiter.
*
* @version 1.2 vom 07.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/


//TODO Frame auslagern, hier wird Kommunikation mit Server geregelt (= extends UnicastRemoteObject)

@SuppressWarnings("serial")
public class TicTacToe_client_Impl extends JFrame implements TicTacToe_client {
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

		// Ende Attributes


	public TicTacToe_client_Impl(String title, TicTacToe_server server){
		// Frame-Initialisierung
				super(title);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton_ActionPerformedCS(evt, holder);
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
							server.jButton10_ActionPerformedCS(evt);
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

		
	}//Konstruktor
	
	@Override
	public void setSignSC(int position, String symbol) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void reset() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void victorySC(int winner) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		TicTacToe_server server = null;
		try {
			server = (TicTacToe_server)
					Naming.lookup("rmi://localhost/TicTacToe:1099");
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (RemoteException e) {
			System.out.println(e);
		} catch (NotBoundException e) {
			System.out.println(e);
		}
		if(server == null) {
			System.out.println("Keine Verbindung zum Server m�glich, bitte erneut versuchen!");
			System.exit(1);
		}
		@SuppressWarnings("unused")
		TicTacToe_client_Impl game = new TicTacToe_client_Impl("TicTacToe", server);	

	}//main	

}// class TicTacToe_client_Impl

/* TODO
 * setSignSC(){
 * textFelder[(holder - 1)].setText(Symbol);
 * jTextField2.setText("" + Player);
 * jTextField3.setText(Symbol); ???
 * buttons.get((holder - 1)).setEnabled(false);
 * } 
 * 
 * TODO
 * vitorySC(winner){
 * if (winner == 1)
 * 		jTextField4.setText("You win!");
 * else if (winner == 2)
 *		jTextField4.setText("Opponent wins!");
 * else		[winner ist dann 0]
 * 		jTextField4.setText("Draw!");
 * jButton10.setEnabled(true); 
 * for (JButton button : buttons)
 * button.setEnabled(false);
 * }
 */
