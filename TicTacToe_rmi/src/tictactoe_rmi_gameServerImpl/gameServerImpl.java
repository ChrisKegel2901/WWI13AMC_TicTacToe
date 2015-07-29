package tictactoe_rmi_gameServerImpl;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import tictactoe_rmi_gameHandle.gameHandle;
import tictactoe_rmi_gameServer.gameServer;
import tictactoe_rmi_gameSession.gameSession;
import tictactoe_rmi_gameSessionImpl.gameSessionImpl;

/**
*
* Dies ist die Server - Klasse des TicTacToe Spiels.
* Hier laeuft die Spielelogik, die durch die jeweiligen Clients aufgerufen wird.
* Die Clients stellen die GUI, der Server die Methoden.
*
* @version 1.2 vom 07.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
@SuppressWarnings("serial")
public class gameServerImpl extends UnicastRemoteObject implements gameServer {
	
	List<gameSessionImpl> sessions = new ArrayList<gameSessionImpl>();
	private int player = 1;
	private String symbol = "X";
	private gameSessionImpl player1;
	private gameSessionImpl player2;
	int playercount;
	private int[] pl = new int[9];
	private int[] i = new int[9];
	
	

	public gameServerImpl(int port) throws RemoteException {
		super();
		// Den Server bei der rmiregistry anmelden (binden)
		System.out.println(
				"TicTacToe - Konstruktor: " +
				"Den Server bei der rmiregistry anmelden (binden)...");
		try {
			LocateRegistry.createRegistry(port);
			Naming.rebind("rmi://localhost:"+port+"/gameServer", this);
			System.out.println(
					"TicTacToe - Konstruktor: " +
					"Server wurde erfolgreich angemeldet!");
			playercount = 0;
		} catch (MalformedURLException e) {
			System.out.println("TicTacToe - Konstruktor: URL fehlerhaft:");
			e.printStackTrace();
			System.exit(1);
		}
	} //Konstruktor

	/**
	 * erstellen der Session und hinzufuegen des jeweiligen Client Handlers
	 */
	@Override
	public gameSession createSession(String name, gameHandle handle) throws RemoteException {
		gameSessionImpl s;
		s = new gameSessionImpl (this, name, handle);
		if (playercount == 0){
			playercount++;
			player1 = s;
			player1.getClientHandle().resetSC(0, "X");
		} else if (playercount == 1){
			playercount++;
			player2 = s;
			player1.getClientHandle().resetSC(1, "X");
			player2.getClientHandle().resetSC(2, "X");
		}
		sessions.add(s);
		return s;
	}
	
	/**
	 * Loeschen einer Session
	 * @param session zu loeschende Session
	 */
	public void removeSession(gameSession session) {
		sessions.remove(session);
	}
	
	/**
	 * Button zum setzen eines Zeichens wurde gedrueckt,
	 * Server gibt Position und Zeichen an den Handler
	 */
	@Override
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException {
		if (i[(holder - 1)] == 0) {
			if (player == 1) {
				pl[(holder - 1)] = 1;
				player = 2;
				player1.getClientHandle().setSignSC(holder, symbol, 2);
				player2.getClientHandle().setSignSC(holder, symbol, 1);
				symbol = "O";
				
			} else {
				pl[(holder - 1)] = 2;
				player = 1;
				player1.getClientHandle().setSignSC(holder, symbol, 1);
				player2.getClientHandle().setSignSC(holder, symbol, 2);
				symbol = "X";
			}
			i[(holder - 1)] = 1;
			try {
				victory();
			} catch (RemoteException e){
				System.out.println("Konnte Client nicht mitteilen, wer gewonnen hat!");
			}
		}
	}			

	/**
	 * Button zum Zuruecksetzen des Feldes wurde gedrueckt,
	 * Variablen werden auf Anfang gesetzt um ein neues Spiel zu ermoeglichen
	 */
	@Override
	public void jButton10_ActionPerformedCS(ActionEvent evt)
			throws RemoteException {
		player1.getClientHandle().resetSC(1, "X");
		player2.getClientHandle().resetSC(2, "X");
		for (int h = 0; h < i.length; h++) {
			i[h] = 0;
		}
		for (int k = 0; k < pl.length; k++) {
			pl[k] = 0;
		}

		player = 1;
		symbol = "X";
	}

	
	/**
	 * Server prueft, ob jemand gewonnen hat.
	 * Wenn ja wird diese Info an die Client Handler weitergegeben
	 * @throws RemoteException
	 */
	public void victory() throws RemoteException  {
		// Sieg Horizontal

				if (pl[0] == pl[1]) {
					if (pl[1] == pl[2]) {
						if (pl[1] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
							
						} else if (pl[1] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				if (pl[3] == pl[4]) {
					if (pl[4] == pl[5]) {
						if (pl[4] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[4] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				if (pl[6] == pl[7]) {
					if (pl[7] == pl[8]) {
						if (pl[7] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[7] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}

				// Sieg Diagonal
				if (pl[0] == pl[4]) {
					if (pl[4] == pl[8]) {
						if (pl[4] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[4] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				if (pl[2] == pl[4]) {
					if (pl[4] == pl[6]) {
						if (pl[4] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[4] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}

				// Sieg Vertikal
				if (pl[0] == pl[3]) {
					if (pl[3] == pl[6]) {
						if (pl[3] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[3] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				if (pl[1] == pl[4]) {
					if (pl[4] == pl[7]) {
						if (pl[4] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[4] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				if (pl[2] == pl[5]) {
					if (pl[5] == pl[8]) {
						if (pl[5] == 1) {
							player1.getClientHandle().victorySC(1);
							player2.getClientHandle().victorySC(2);
						} else if (pl[5] == 2) {
							player1.getClientHandle().victorySC(2);
							player2.getClientHandle().victorySC(1);
						}
					}
				}
				int h = 0;
				for (int j = 0; j<i.length;j++){
					h+=i[j];
				}
				if (h == 9){
					player1.getClientHandle().victorySC(0);
					player2.getClientHandle().victorySC(0);
				}
			
	}//victory

	
	/**
	 * Nur Testweise, Server wird von lobby aus gestartet (erstellen)
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new gameServerImpl(1099);
		} catch (RemoteException e) {
			System.out.println("Server wurde nicht gestartet");
		}

	} //main

	

} //class TicTacToe_rmi_gameServerImpl
