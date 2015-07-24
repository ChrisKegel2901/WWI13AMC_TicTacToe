package TicTacToe_rmi_chatSession;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chatSession extends Remote {

	public void sendMessage(String message) throws RemoteException;

	public void sendGame(String game) throws RemoteException;

}
