package TicTacToe_rmi_chatServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatSession.chatSession;

public interface chatServer extends Remote {

	public chatSession createSession(String nickname, chatHandle handle) throws RemoteException;

}
