package TicTacToe_rmi_chatHandleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TicTacToe_rmi_chatHandle.chatHandle;
import lobby_rmi.lobby;

import java.rmi.Naming;

@SuppressWarnings("serial")
public class chatHandleImpl extends UnicastRemoteObject implements chatHandle {
	lobby client;

	public chatHandleImpl(lobby client) throws RemoteException {
		this.client = client;
	}

	public chatHandleImpl() throws RemoteException {
	}

	public void receiveMessage(String nickname, String message) {
		client.receiveMessage(nickname, message);
	}

	public void receiveGame(String game) {
		client.receiveGame(game);
		
	}

}
