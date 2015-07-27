package TicTacToe_rmi_chatServerImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;

import java.util.List;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatServer.chatServer;
import TicTacToe_rmi_chatSession.chatSession;
import TicTacToe_rmi_chatSessionImpl.chatSessionImpl;

import java.util.ArrayList;
/**
*
* Dies ist die Klasse zur Implementierung des Chat- und Lobby-Servers. 
*
*
* @version 1.0 vom 23.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
@SuppressWarnings("serial")
public class chatServerImpl extends UnicastRemoteObject implements chatServer {
	List<chatSessionImpl> sessions = new ArrayList<chatSessionImpl>();

	public chatServerImpl() throws RemoteException {
	}

	/**
	*
	* Erstellt ueber den Nutzernamen und den dazugehoerigen Handler eine Session im Chat-Server
	* 
	*  @param nickname Benutzername eines Clients
	*  @param handle Chat-Handler des Clients
	*  @return chatSession Instanz
	*  @throws java.rmi.RemoteException
	* 
	*
	*/
	public chatSession createSession(String nickname, chatHandle handle) throws RemoteException {
		System.out.println("create session: " + nickname);
		chatSessionImpl s = new chatSessionImpl(this, nickname, handle);
		sessions.add(s);
		return s;
	}

	
	
	/**
	*
	* Sendet eine Nachricht an alle in der ArrayList vorhanden Clients, via for-Schleife. Indem es die Funktion receiveMessage jedes Clients aufruft.
	* 
	*  @param s Beinhaltet eine instanziierte Chat-Session
	*  @param message Die zu uebergebene Nachricht
	* 
	*
	*/
	public void postMessage(String message, chatSessionImpl s) {
		chatSessionImpl tmp;
		for (int i = 0; i < sessions.size(); i++) {
			tmp = (chatSessionImpl) sessions.get(i);
			try {
				tmp.getClientHandle().receiveMessage(s.getNickname(), message);
			} catch (RemoteException ex) {
				System.out.println("unabled to contact client " + s.getNickname());
				System.out.println("removing.");
				removeSession(tmp);
				i--; 
			}
		}
	}
	
	
	/**
	*
	* Sendet eine erstelltes Spiel an alle in der ArrayList vorhanden Clients, via for-Schleife. Indem es die Funktion receiveGame jedes Clients aufruft.
	* 
	*  @param game Beinhaltet das zu uebergebende Spiel
	*  @throws java.rmi.RemoteException
	*
	*/
	public void postGame(String game) throws RemoteException {
		chatSessionImpl tmp;
		for (int i = 0; i < sessions.size(); i++) {
			tmp = (chatSessionImpl) sessions.get(i);
			tmp.getClientHandle().receiveGame(game);
		}
	}

	/**
	*
	* Entfernt eine session aus der ArrayList sessions
	*  @param session Die zu entfernende Session 
	*
	*/
	public void removeSession(chatSession session) {
		sessions.remove(session);
	}

	
	/**
	*
	*  Startet zuerst die RMI-Registry und danach den Chat-Server 
	*
	*/
	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(2021);
			Naming.rebind("rmi://192.168.0.12:2021/chat-server", new chatServerImpl());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}