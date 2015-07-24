package TicTacToe_rmi_chatSessionImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatServerImpl.chatServerImpl;
import TicTacToe_rmi_chatSession.chatSession;
@SuppressWarnings("serial")
public class chatSessionImpl extends UnicastRemoteObject implements chatSession {
	chatServerImpl server;
	String nickname;
	chatHandle handle;

	public chatSessionImpl() throws RemoteException {
	}

	public chatSessionImpl(chatServerImpl server, String nickname, chatHandle handle) throws RemoteException {
		this.server = server;
		this.nickname = nickname;
		this.handle = handle;
	}

	public void sendMessage(String message) {
		server.postMessage(message, this);
	}
	
	public void sendGame(String game) throws RemoteException {
		server.postGame(game);
	}

	public chatHandle getClientHandle() {
		return handle;
	}

	public String getNickname() {
		return nickname;
	}

}
