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

	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton chatButton = new JButton();

	private JTextField jTextField1 = new JTextField();
	private JTextField chatFeld = new JTextField();
	

	chatHandle handle;
	chatSession session;
	String nickname;
	private JLabel jLabel1 = new JLabel();

	private int[] i = new int[9];

	final DefaultListModel<String> model;
	final DefaultListModel<String> chat;

	private JButton jButton10 = new JButton();

	private void senden() throws RemoteException {
		String msg = chatFeld.getText();

		session.sendMessage(msg);
		chatFeld.setText("");

	}

	public lobby(String name) throws MalformedURLException, RemoteException, NotBoundException {

		chatServer server = (chatServer) Naming.lookup("//localhost:2021/chat-server");
		handle = new chatHandleImpl(this);
		session = server.createSession(name, handle);
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
		for (int j = 0; j < i.length; j++) {
			i[j] = 0;
		}
		jButton1.setBounds(510, 345, 115, 33);
		jButton1.setText("Beitreten");
		jButton1.setMargin(new Insets(2, 2, 2, 2));

		cp.add(jButton1);
		jButton2.setBounds(510, 423, 115, 33);
		jButton2.setText("Erstellen");
		jButton2.setMargin(new Insets(2, 2, 2, 2));
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = jTextField1.getText();
				try {
					session.sendGame(a);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		cp.add(jButton2);

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

		jTextField1.setBounds(510, 390, 115, 32);
		jTextField1.setText("");
		jTextField1.setEditable(true);
		cp.add(jTextField1);

		chatFeld.setBounds(101, 423, 403, 32);
		chatFeld.setText("");
		chatFeld.setEditable(true);
		cp.add(chatFeld);

		jLabel1.setBounds(225, 16, 190, 32);
		jLabel1.setText("TIC-TAC-TOE");
		jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 23));
		cp.add(jLabel1);

		buttons.add(jButton1);

		model = new DefaultListModel<String>();
		
		chat = new DefaultListModel<String>();

		final JList<String> list = new JList<String>(model);
		final JList<String> chatList = new JList<String>(chat);

		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(510, 65, 115, 275);
		add(pane);

		JScrollPane chatPane = new JScrollPane(chatList);
		chatPane.setBounds(15, 65, 485, 355);
		add(chatPane);
		// Ende Komponenten
		jButton10.setEnabled(false);
		setResizable(false);
		setVisible(true);
	}

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

	public void receiveMessage(String nickname, String message) {
		chat.addElement(nickname + ": " + message);

	}
	public void receiveGame(String game) {
		model.addElement(game);

	}
}
