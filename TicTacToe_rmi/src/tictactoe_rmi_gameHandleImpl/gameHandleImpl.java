package tictactoe_rmi_gameHandleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tictactoe_game.game;
import tictactoe_rmi_gameHandle.gameHandle;

@SuppressWarnings("serial")
public class gameHandleImpl extends UnicastRemoteObject implements gameHandle {
	game client;

	public gameHandleImpl(game client) throws RemoteException {
		this.client = client;
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
