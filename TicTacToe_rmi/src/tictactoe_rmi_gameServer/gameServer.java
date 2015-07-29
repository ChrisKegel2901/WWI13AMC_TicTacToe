/**
 * Das Remote-Interface fuer das
 * TicTacToe_rmi Projekt (Server Interface)
 */
package tictactoe_rmi_gameServer;

import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

import tictactoe_rmi_gameHandle.gameHandle;
import tictactoe_rmi_gameSession.gameSession;

/**
 * Diese Interface regelt die Kommunikation
 * zwischen Client und Server. Alle entfernten
 * Methoden, die der Server anbietet (=implementiert)
 * muessen hierin aufgefuehrt werden.
 * @author Christian Kegelmann, Philipp Naeser WWI13AMC
 * @version 1.2 07.07.2015
 */
public interface gameServer extends Remote {
	
		
	/**
	 * Diese Methode setzt die "X" bzw. "O", wenn der
	 * entsprechende Button gedrueckt wird.
	 * Dabei wird das ActionEvent des gedrueckten Buttons uebergeben.
	 * @param evt Actionevent des gedrueckten Buttons
	 * @param holder Stelle an der eingefügt wird.
	 * @throws RemoteException
	 */
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException;
	
	/**
	 * Hier wird das Spiel zurueckgesetzt und neu gestartet.
	 * Dabei wird das ActionEvent des gedrueckten Buttons uebergeben.
	 * @param Actionevent des gedrueckten Buttons
	 * @throws RemoteException
	 */
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException;

	/**
	 * Methode, mit dem der Client sich beim Server anmeldet.
	 * Dabei wird eine neue gameSession erstellt, die den gameHandler des Spielers enthält
	 * @throws RemoteException
	 */
	public gameSession createSession(String name, gameHandle handle) throws RemoteException;
	

}//class TicTacToe_rmi_gameServer