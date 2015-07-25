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

@SuppressWarnings("serial")
public class chatServerImpl extends UnicastRemoteObject implements chatServer {
	List sessions = new ArrayList();

	public chatServerImpl() throws RemoteException {
	}

	public chatSession createSession(String nickname, chatHandle handle) throws RemoteException {
		System.out.println("create session: " + nickname);
		chatSessionImpl s = new chatSessionImpl(this, nickname, handle);
		sessions.add(s);
		return s;
	}

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
				i--; // Da nun alle Clients in Liste einen Platz nach unten
						// rutschen ...
			}
		}
	}
	
	public void postGame(String game) throws RemoteException {
		chatSessionImpl tmp;
		for (int i = 0; i < sessions.size(); i++) {
			tmp = (chatSessionImpl) sessions.get(i);
			tmp.getClientHandle().receiveGame(game);
		}
	}

	public void removeSession(chatSession session) {
		sessions.remove(session);
	}

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(2021);
			Naming.rebind("rmi://192.168.0.12:2021/chat-server", new chatServerImpl());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}