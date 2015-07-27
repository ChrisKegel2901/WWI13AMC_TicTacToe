package TicTacToe_rmi_chatSessionImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatServerImpl.chatServerImpl;
import TicTacToe_rmi_chatSession.chatSession;

/**
*
* Diese Klasse implementiert das Interface chatSession.
* 
* @version 1.0 vom 23.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
@SuppressWarnings("serial")
public class chatSessionImpl extends UnicastRemoteObject implements chatSession {
	chatServerImpl server;
	String nickname;
	chatHandle handle;

	public chatSessionImpl() throws RemoteException {
	}

	/**
	*
	* Schreibt die uebergebenen Werte in dafuer vorgesehenen Platzhalter-Variablen dieser Klasse.
	* @param server Ein Objekt der Klasse chatServerImpl
	* @param nickname Der Benutzername eines Clients
	* @param handle Der zum Client gehoerige Chat-Handler
	* @throws java.rmi.RemoteException
	*/
	public chatSessionImpl(chatServerImpl server, String nickname, chatHandle handle) throws RemoteException {
		this.server = server;
		this.nickname = nickname;
		this.handle = handle;
	}
	
	/**
	*
	*  Sendet eine Nachricht an den Server
	* 
	*  @param message Die zu sendende Nachricht
	*  
	*/
	public void sendMessage(String message) {
		server.postMessage(message, this);
	}
	
	
	/**
	*
	*  Sendet ein erstelltes Spiel an den Server
	* 
	*  @param game Das erstellte Spiel
	*  @throws java.rmi.RemoteException
	*/
	public void sendGame(String game) throws RemoteException {
		server.postGame(game);
	}

	/**
	*
	*  Gibt den zum Client gehoerigen Chat-Handler aus.
	* 
	*  @return Zum Client gehoeriger Chat-Handler.
	*/
	public chatHandle getClientHandle() {
		return handle;
	}

	/**
	*
	*  Gibt den zum Client gehoerigen Benutzernamen aus.
	* 
	*  @return Zum Client gehoeriger Benutzername.
	*/
	public String getNickname() {
		return nickname;
	}

}
