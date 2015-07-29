package tictactoe_rmi_gameSession;

import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface gameSession extends Remote{
	
	/**
	 * Button wurde gedrueckt, Session gibt Info an Server welcher und von wem.
	 * @param evt Button gedrueckt Event
	 * @param holder Welcher Client hat gedrueckt (bzw. dessen Handler)
	 * @throws RemoteException
	 */
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException;
	
	/**
	 * Resetbutton wurde gedrueckt, Info an Server Variablen auf Anfang zu setzen
	 * @param evt Button gedrueckt Event.
	 * @throws RemoteException
	 */
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException;

}
