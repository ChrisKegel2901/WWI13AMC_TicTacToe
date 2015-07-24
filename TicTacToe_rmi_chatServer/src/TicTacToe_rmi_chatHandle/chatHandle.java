package TicTacToe_rmi_chatHandle;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chatHandle extends Remote {

	public void receiveMessage(String nickname, String message) throws RemoteException;

	public void receiveGame(String game)  throws RemoteException;

}
