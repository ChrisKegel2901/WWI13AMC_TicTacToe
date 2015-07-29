package tictactoe_rmi_gameSessionImpl;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tictactoe_rmi_gameHandle.gameHandle;
import tictactoe_rmi_gameServerImpl.gameServerImpl;
import tictactoe_rmi_gameSession.gameSession;

@SuppressWarnings("serial")
public class gameSessionImpl extends UnicastRemoteObject implements gameSession {
	gameServerImpl server;
	String nickname;
	gameHandle handle;

	public gameSessionImpl(gameServerImpl server, String nickname, gameHandle handle) throws RemoteException {
		this.server = server;
		this.nickname = nickname;
		this.handle = handle;
	} //Konstruktor
	
	
	@Override
	public void jButton_ActionPerformedCS(ActionEvent evt, int holder) throws RemoteException{
		server.jButton_ActionPerformedCS(evt, holder);
	}
	
	@Override
	public void jButton10_ActionPerformedCS(ActionEvent evt) throws RemoteException{
		server.jButton10_ActionPerformedCS(evt);
	}
	/**
	*
	*  Gibt den zum Client gehoerigen Game-Handler aus.
	* 
	*  @return Zum Client gehoeriger Game-Handler.
	*/
	public gameHandle getClientHandle() {
		return handle;
	}

	/**
	*
	*  Gibt den zum Client gehoerigen Benutzernamen aus.
	* 
	*  @return Zum Client gehoeriger Benutzername.
	*/
	public String getNickname() {
		return nickname;
	}
	
} //class gameSessionImpl
