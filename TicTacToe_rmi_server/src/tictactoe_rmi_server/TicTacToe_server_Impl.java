package tictactoe_rmi_server;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



import tictactoe_rmi_interface.TicTacToe_server;
import tictactoe_rmi_interface.TicTacToe_client;

/**
*
* Dies ist die Server - Klasse des TicTacToe Spiels.
* Hier läuft die Spielelogik, die durch die jeweiligen Clients aufgerufen wird.
* Die Clients stellen die GUI, der Server die Methoden.
*
* @version 1.2 vom 07.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
@SuppressWarnings("serial")
public class TicTacToe_server_Impl extends UnicastRemoteObject implements TicTacToe_server {
	
	private int player = 1;
	private String symbol = "X";
	private TicTacToe_client player1;
	private TicTacToe_client player2;
	private int[] pl = new int[9];
	private int[] i = new int[9];
	
	

	protected TicTacToe_server_Impl() throws RemoteException {
		super();
		// Den Server bei der rmiregistry anmelden (binden)
		System.out.println(
				"TicTacToe - Konstruktor: " +
				"Den Server bei der rmiregistry anmelden (binden)...");
		try {
			Naming.rebind("rmi://localhost/TicTacToe:1099", this);
		} catch (MalformedURLException e) {
			System.out.println("TicTacToe - Konstruktor: URL fehlerhaft:");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println(
				"TicTacToe - Konstruktor: " +
				"Server wurde erfolgreich angemeldet!");
	} //Konstruktor

	@Override
	public void anmeldenCS() throws RemoteException{
		//TODO player1 und player2 setzen
	}
	
	@Override
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException {
		if (i[(holder - 1)] == 0) {
			if (player == 1) {
				pl[(holder - 1)] = 1;
				player = 2;
				player1.setSignSC(holder, symbol, 2);
				player2.setSignSC(holder, symbol, 1);
				symbol = "O";
				
			} else {
				pl[(holder - 1)] = 2;
				player = 1;
				player1.setSignSC(holder, symbol, 1);
				player2.setSignSC(holder, symbol, 2);
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
		

	@Override
	public void jButton10_ActionPerformedCS(ActionEvent evt)
			throws RemoteException {
		player1.resetSC(1, "X");
		player2.resetSC(2, "X");
		for (int h = 0; h < i.length; h++) {
			i[h] = 0;
		}
		for (int k = 0; k < pl.length; k++) {
			pl[k] = 0;
		}

		player = 1;
		symbol = "X";
	}

	
	public void victory() throws RemoteException  {
		// Sieg Horizontal

				if (pl[0] == pl[1]) {
					if (pl[1] == pl[2]) {
						if (pl[1] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
							
						} else if (pl[1] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				if (pl[3] == pl[4]) {
					if (pl[4] == pl[5]) {
						if (pl[4] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[4] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				if (pl[6] == pl[7]) {
					if (pl[7] == pl[8]) {
						if (pl[7] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[7] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}

				// Sieg Diagonal
				if (pl[0] == pl[4]) {
					if (pl[4] == pl[8]) {
						if (pl[4] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[4] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				if (pl[2] == pl[4]) {
					if (pl[4] == pl[6]) {
						if (pl[4] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[4] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}

				// Sieg Vertikal
				if (pl[0] == pl[3]) {
					if (pl[3] == pl[6]) {
						if (pl[3] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[3] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				if (pl[1] == pl[4]) {
					if (pl[4] == pl[7]) {
						if (pl[4] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[4] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				if (pl[2] == pl[5]) {
					if (pl[5] == pl[8]) {
						if (pl[5] == 1) {
							player1.victorySC(1);
							player2.victorySC(2);
						} else if (pl[5] == 2) {
							player1.victorySC(2);
							player2.victorySC(1);
						}
					}
				}
				int h = 0;
				for (int j = 0; j<i.length;j++){
					h+=i[j];
				}
				if (h == 9){
					player1.victorySC(0);
					player2.victorySC(0);
				}
			
	}//victory

	
	

}//class TicTacToe
