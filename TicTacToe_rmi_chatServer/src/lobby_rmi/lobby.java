package lobby_rmi;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatHandleImpl.chatHandleImpl;
import TicTacToe_rmi_chatServer.chatServer;
import TicTacToe_rmi_chatSession.chatSession;
import tictactoe_game.game;

/**
 *
 * Dies ist die Lobby - Klasse des TicTacToe Spiels. Hier wird der Chat und die
 * Spiel-Erstellung bzw. der Spiel-Beitritt realisiert. Die Clients stellen die
 * GUI, der Server die Methoden.
 *
 * @version 1.0 vom 23.07.2015
 * @author Philipp Naeser, Christian Kegelmann WWI13AMC
 */
@SuppressWarnings("serial")
public class lobby extends JFrame {

	private JButton beitrittButton = new JButton();
	private JButton erstellenButton = new JButton();
	private JButton chatButton = new JButton();
	private ArrayList<Integer> gameList2 = new ArrayList<Integer>();
	private ArrayList<String> nameList2 = new ArrayList<String>();
	private JTextField nameSpiel = new JTextField();
	private JTextField chatFeld = new JTextField();

	private chatHandle handle;
	private chatSession session;
	private String nickname;
	private JLabel titel = new JLabel();

	final DefaultListModel<String> model;
	final DefaultListModel<String> chat;
	final JList<String> list;
	final JList<String> chatList;
	
	/**
	 *
	 * Sendet eine Nachricht an den Server
	 *
	 * @throws java.rmi.RemoteException
	 */
	private void senden() throws RemoteException {
		String msg = chatFeld.getText();

		session.sendMessage(msg);
		chatFeld.setText("");

	}
	/**
	 *
	 * Erstellt anhand des Benutzernamen des Users die GUI und baut eine Verbindung zum Chat-/Lobby-Server auf.
	 *
	 * @param name Benutzername des Users
	 * @throws java.net.MalformedURLException
	 * @throws java.rmi.RemoteException
	 * @throws java.rmi.NotBoundException
	 * 
	 */
	public lobby(String name) throws MalformedURLException, RemoteException, NotBoundException {

		// Verbindung zu Server aufbauen

		chatServer server = (chatServer) Naming.lookup("rmi://localhost:2021/chat-server");
		handle = new chatHandleImpl(this);
		session = server.createSession(name, handle);

		// GUI erstellen und KeyListener hinzufuegen

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 640;
		int frameHeight = 480;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		Container cp = getContentPane();
		cp.setLayout(null);
		this.chatFeld.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					try {
						senden();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		// Anfang Komponenten

		beitrittButton.setBounds(510, 345, 115, 33);
		beitrittButton.setText("Beitreten");
		beitrittButton.setMargin(new Insets(2, 2, 2, 2));
		beitrittButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String geklicktesSpiel = list.getSelectedValue();
				System.out.println(geklicktesSpiel);
				int index = 0;
				for (int i = 0; i < (nameList2.size()); i++){
					String a = nameList2.get(i);
					if (a.equals(geklicktesSpiel))
					{
						index = i;
					}
				}
				int portNumber = gameList2.get(index);
				System.out.println(""+portNumber);
				try {
					new game("TicTacToe", portNumber, nickname);
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
					System.out.println("Spiel konnte nicht erstellt werden");
				}
				

			}
		});
		cp.add(beitrittButton);

		erstellenButton.setBounds(510, 423, 115, 33);
		erstellenButton.setText("Erstellen");
		erstellenButton.setMargin(new Insets(2, 2, 2, 2));
		erstellenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = nameSpiel.getText();
				try {
					
					session.sendGame(a, (1099 + gameList2.size()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		cp.add(erstellenButton);

		chatButton.setBounds(11, 423, 85, 33);
		chatButton.setText("Senden");
		chatButton.setMargin(new Insets(2, 2, 2, 2));
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					senden();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cp.add(chatButton);

		nameSpiel.setBounds(510, 390, 115, 32);
		nameSpiel.setText("");
		nameSpiel.setEditable(true);
		cp.add(nameSpiel);

		chatFeld.setBounds(101, 423, 403, 32);
		chatFeld.setText("");
		chatFeld.setEditable(true);
		cp.add(chatFeld);

		titel.setBounds(225, 16, 190, 32);
		titel.setText("TIC-TAC-TOE");
		titel.setFont(new Font("MS Sans Serif", Font.PLAIN, 23));
		cp.add(titel);

		model = new DefaultListModel<String>();
		chat = new DefaultListModel<String>();

		list = new JList<String>(model);
		chatList = new JList<String>(chat);

		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(510, 65, 115, 275);
		add(pane);

		JScrollPane chatPane = new JScrollPane(chatList);
		chatPane.setBounds(15, 65, 485, 355);
		add(chatPane);
		// Ende Komponenten

		setResizable(false);
		setVisible(true);
	}
	/**
	 *
	 * Fragt den Benutzernamen des Users ab und erstellt mit diesem ein Objekt der Klasse lobby
	 */
	public static void main(String[] args) {
		try {
			String name = JOptionPane.showInputDialog(null, "Eingabe des Nickname");
			if (name != null && name.trim().length() > 0) {
				lobby client = new lobby(name);
				client.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Nickname mit mehr als 1 Zeichen ein.");
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}

	}


/**
 *
 * Empfaengt eine Nachricht vom Server und traegt sie in das Chat-Fenster ein
 *
 * @param nickname Benutzername des Senders
 * @param message Die Nachricht des Senders
 */
	public void receiveMessage(String nickname, String message) {
		chat.addElement(nickname + ": " + message);

	}

	
	/**
	 *
	 * Empfaengt ein Spiel vom Server und traegt sie in die Spiel-Liste ein
	 *
	 * @param game Ein erstelltes Spiel
	 */
	public void receiveGame(String game, ArrayList<Integer> gameList, ArrayList<String> nameList) {
		nameList2 = nameList;
		gameList2 = gameList;
		model.clear();
		for (int i = 0; i < nameList.size(); i++){
			model.addElement(nameList.get(i));
		}
		

	}
}
