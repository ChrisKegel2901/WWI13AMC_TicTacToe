package tictactoe_rmi_gameSession;

import java.awt.event.ActionEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface gameSession extends Remote{
	
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException;
	
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException;

}
