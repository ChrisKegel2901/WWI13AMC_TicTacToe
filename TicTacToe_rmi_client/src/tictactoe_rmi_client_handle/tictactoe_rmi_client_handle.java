package tictactoe_rmi_client_handle;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tictactoe_rmi_client.TicTacToe_client_Impl;
import tictactoe_rmi_interface.TicTacToe_client;
import tictactoe_rmi_interface.TicTacToe_server;

@SuppressWarnings("serial")
public class tictactoe_rmi_client_handle extends UnicastRemoteObject implements TicTacToe_client {
	TicTacToe_client_Impl client;
	TicTacToe_server gameServer;

	protected tictactoe_rmi_client_handle() throws RemoteException {
		super();
	}
	
	public tictactoe_rmi_client_handle(String name, int portNumber, String nickname) throws RemoteException{
		super();
		this.client = new TicTacToe_client_Impl(name, portNumber, nickname);
		
		try {			
			gameServer = (TicTacToe_server)
					Naming.lookup("rmi://localhost:"+portNumber+"/TicTacToe");
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (RemoteException e) {
			System.out.println(e);
		} catch (NotBoundException e) {
			System.out.println(e);
		}
		if(gameServer == null) {
			System.out.println("Keine Verbindung zum Server moeglich, bitte erneut versuchen!");
			System.exit(1);
		}
		
		String url = "rmi://localhost:"+portNumber+"/" + nickname;
		try {
			Naming.rebind(url, this);
		} catch (RemoteException | MalformedURLException e1) {
			System.out.println("Client konnte sich nicht bei RMI binden");
		}
		System.out.println("Client meldet sich beim Spielserver an!");
		try {
			gameServer.anmeldenCS(url);
			System.out.println("angemeldet");
		} catch (RemoteException e) {
			System.out.println("Konnte nicht beim Server angemeldet werden!");
		}
		
	}

	@Override
	public void setSignSC(int position, String symbol, int player) throws RemoteException {
		client.setSign(position, symbol, player);
		
	}

	@Override
	public void resetSC(int player, String symbol) throws RemoteException {
		client.reset(player, symbol);
	}

	@Override
	public void victorySC(int winner) throws RemoteException {
		client.victory(winner);		
	}

}
