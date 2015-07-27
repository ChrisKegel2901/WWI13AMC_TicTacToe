package TicTacToe_rmi_chatSession;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
*
* Dies ist das Interface fuer die Klasse chatSession. Sie stellt die Methoden sendMessage und sendGame bereit.
*
* @version 1.0 vom 23.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
public interface chatSession extends Remote {

	/**
	*
	*  Sendet eine Nachricht an den Server
	* 
	*  @param message Die zu sendende Nachricht
	*  @throws java.rmi.RemoteException
	*/
	public void sendMessage(String message) throws RemoteException;

	
	/**
	*
	*  Sendet ein erstelltes Spiel an den Server
	* 
	*  @param game Das erstellte Spiel
	*  @throws java.rmi.RemoteException
	*/
	public void sendGame(String game) throws RemoteException;

}
