package TicTacToe_rmi_chatHandle;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * Dies ist das Interface fuer die Klasse chatHandleImpl. Sie stellt die Methoden receiveMessage und 
 * receiveGame bereit.
 *
 * @version 1.0 vom 23.07.2015
 * @author Philipp Naeser, Christian Kegelmann WWI13AMC
 */
public interface chatHandle extends Remote {

	public void receiveMessage(String nickname, String message) throws RemoteException;

	public void receiveGame(String game)  throws RemoteException;

}
