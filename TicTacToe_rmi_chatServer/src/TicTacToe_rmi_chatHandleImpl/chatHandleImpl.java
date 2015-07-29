package TicTacToe_rmi_chatHandleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TicTacToe_rmi_chatHandle.chatHandle;
import lobby_rmi.lobby;

/**
 *
 * Dies ist die Klasse zur Implementierung des Chat Handlers. Sie traegt eine ihr uebergebenes Lobby-Objekt
 * in eine dafuer vorgesehene Variable ein und empfaengt ueber die Methoden receiveMessage und receiveGame die gesendeten  
 * Nachrichten und erstellten Spiele.
 * 
 * @param client Speichert das uebergebene Lobby-Objekt
 *
 * @version 1.0 vom 23.07.2015
 * @author Philipp Naeser, Christian Kegelmann WWI13AMC
 */
@SuppressWarnings("serial")
public class chatHandleImpl extends UnicastRemoteObject implements chatHandle {
	lobby client;

	 /** 
	  * Konstruktor. Nimmt ein uebergebenes Lobby-Objekt und speichert es in der Variable client.
	  * @param client Speichert das uebergebene Lobby-Objekt
	  * @throws java.rmi.RemoteException 
	*/
	public chatHandleImpl(lobby client) throws RemoteException {
		this.client = client;
	}

	 /** 
	  * Bekommt den nickname und eine message vom Client uebergeben und fuert damit die Methode receiveMessage auf dem Objekt client aus.
	*/
	public void receiveMessage(String nickname, String message) {
		client.receiveMessage(nickname, message);
	}

	 /**
	  * Bekommt den Spiel-Namen vom Client uebergeben und fuert damit die Methode receiveGame auf dem Objekt client aus.
	*/
	public void receiveGame(String game, ArrayList<Integer> gameList, ArrayList<String> nameList) {
		client.receiveGame(game, gameList, nameList);
		
	}

	

}
