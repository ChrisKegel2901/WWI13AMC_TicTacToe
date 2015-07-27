package tictactoe_rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Diese Interface regelt die Kommunikation
 * zwischen Client und Server. Alle entfernten
 * Methoden, die der Client anbietet (=implementiert)
 * muessen hierin aufgefuehrt werden.
 * @author Christian Kegelmann, Philipp Naeser WWI13AMC
 * @version 1.2 07.07.2015
 */
public interface TicTacToe_client extends Remote {

	/**
	 * Hier gibt der Server dem Client an, 
	 * welches Zeichen an welcher Position gerade gesetzt wurde.
	 * @param position position, an der Zeichen eingefügt wird
	 * @param symbol welches Zeichen wird eingefügt
	 * @param player welcher Spieler ist an der Reihe	 * 
	 * @throws RemoteException
	 */
	public void setSignSC (int position, String symbol, int player) throws RemoteException;
	
	/**
	 * Hier wird dem Client die Anweisung gegeben, das
	 * Spielfeld zurückzusetzen und von vorne zu beginnen
	 * @param player welcher Spieler ist an der Reihe
	 * @param symbol welcher Symbol hat der Spieler, der an der Reihe ist.
	 * @throws RemoteException
	 */
	public void reset (int player, String symbol) throws RemoteException;
	
	/**
	 * Hier errechnet der Server, dass das Spiel beendet wurde und gibt
	 * dem Client an, wer gewonnen hat.
	 * @param winner wenn 0 --> unentschieden, 1 --> client hat gewonnen, 2 --> client hat verloren
	 * @throws RemoteException
	 */
	public void victorySC (int winner) throws RemoteException;
}
