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
	 * Diese Methode setzt die "X" bzw. "O", wenn der
	 * entsprechende Button gedr�ckt wird.
	 * Dabei wird das ActionEvent des gedr�ckten Buttons �bergeben.
	 * @param Actionevent des gedr�ckten Buttons
	 * 
	 */
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException;
	
	/**
	 * Hier wird das Spiel zur�ckgesetzt und neu gestartet.
	 * Dabei wird das ActionEvent des gedr�ckten Buttons �bergeben.
	 * @param Actionevent des gedr�ckten Buttons
	 * 
	 */
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException;
	
	
	

}//class TicTacToe_int
