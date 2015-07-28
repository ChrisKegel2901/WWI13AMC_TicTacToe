/**
 * Das Remote-Interface fuer das
 * TicTacToe_rmi Projekt
 */
package tictactoe_rmi_interface;

import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Diese Interface regelt die Kommunikation
 * zwischen Client und Server. Alle entfernten
 * Methoden, die der Server anbietet (=implementiert)
 * muessen hierin aufgefuehrt werden.
 * @author Christian Kegelmann, Philipp Naeser WWI13AMC
 * @version 1.2 07.07.2015
 */
public interface TicTacToe_server extends Remote {
	
	/**
	 * Methode, mit dem der Client sich beim Server anmeldet.
	 * Dieser speichert den Client als player1 oder player2 und gibt diese Info an den Client zurück.
	 * @throws RemoteException
	 */
	public void anmeldenCS(TicTacToe_client client) throws RemoteException;
	
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
	 * Dabei wird das ActionEvent des gedrïueckten Buttons ï¿½bergeben.
	 * @param Actionevent des gedrueckten Buttons
	 * @throws RemoteException
	 */
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException;
	
	
	

}//class TicTacToe_int
