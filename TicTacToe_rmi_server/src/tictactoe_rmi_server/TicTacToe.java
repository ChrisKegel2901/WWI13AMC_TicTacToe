package tictactoe_rmi_server;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import tictactoe_rmi_interface.TicTacToe_int;

/**
*
* Dies ist die Server - Klasse des TicTacToe Spiels.
* Hier l�uft die Spielelogik, die durch die jeweiligen Clients aufgerufen wird.
* Die Clients stellen die GUI, der Server die Methoden.
*
* @version 1.2 vom 07.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
@SuppressWarnings("serial")
public class TicTacToe extends UnicastRemoteObject implements TicTacToe_int {

	protected TicTacToe() throws RemoteException {
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
	public void jButton_ActionPerformed(ActionEvent evt) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jButton10_ActionPerformed(ActionEvent evt)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Victory() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	

}//class TicTacToe
