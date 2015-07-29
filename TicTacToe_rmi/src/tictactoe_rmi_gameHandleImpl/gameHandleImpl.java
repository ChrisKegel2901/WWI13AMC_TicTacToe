package tictactoe_rmi_gameHandleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tictactoe_game.game;
import tictactoe_rmi_gameHandle.gameHandle;
/**
 * Implementierung des gameHandle Interfaces
 * @author Philipp N‰ser, Christian Kegelmann
 *
 */
@SuppressWarnings("serial")
public class gameHandleImpl extends UnicastRemoteObject implements gameHandle {
	game client;

	public gameHandleImpl(game client) throws RemoteException {
		this.client = client;
	}// Konstruktor

	/**
	 * gibt das Symbol und die Position vom Server an die Client-gui weiter,
	 * auﬂerdem den jetzt aktiven Spieler
	 */
	@Override
	public void setSignSC(int position, String symbol, int player) throws RemoteException {
		client.setSign(position, symbol, player);	
	} // setSignSC

	/**
	 * gibt die Anweisung vom Server weiter, das Spiel neu zu beginnen
	 */
	@Override
	public void resetSC(int player, String symbol) throws RemoteException {
		client.reset(player, symbol);
	} //resetSC

	/**
	 * gibt weiter, wen der Server als Gewinner ermittelt hat.
	 */
	@Override
	public void victorySC(int winner) throws RemoteException {
		client.victory(winner);
	} //victorySC

}
