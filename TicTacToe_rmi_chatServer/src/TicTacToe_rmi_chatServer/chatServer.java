package TicTacToe_rmi_chatServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import TicTacToe_rmi_chatHandle.chatHandle;
import TicTacToe_rmi_chatSession.chatSession;
/**
*
* Dies ist das Interface fuer die Klasse chatServer. Sie stellt die Methode createSession bereit.
*
* @version 1.0 vom 23.07.2015
* @author Philipp Naeser, Christian Kegelmann WWI13AMC
*/
public interface chatServer extends Remote {

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
	public chatSession createSession(String nickname, chatHandle handle) throws RemoteException;

}
