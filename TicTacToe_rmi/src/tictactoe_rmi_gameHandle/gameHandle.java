package tictactoe_rmi_gameHandle;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Diese Interface regelt die Kommunikation
 * zwischen Client und Server. Alle entfernten
 * Methoden, die der Handler f�r die Client-gui anbietet (=implementiert)
 * muessen hierin aufgefuehrt werden.
 * @author Christian Kegelmann, Philipp Naeser WWI13AMC
 * @version 1.2 07.07.2015
 */
public interface gameHandle extends Remote {
	
	/**
	 * Hier gibt der Server dem Handler (und damit dem Client) an, 
	 * welches Zeichen an welcher Position gerade gesetzt wurde.
	 * @param position position, an der Zeichen eingef�gt wird
	 * @param symbol welches Zeichen wird eingef�gt
	 * @param player welcher Spieler ist an der Reihe	 
	 * @throws RemoteException
	 */
	public void setSignSC (int position, String symbol, int player, int playerAct) throws RemoteException;
		
	/**
	 * Hier wird dem Handler die Anweisung gegeben, das
	 * Spielfeld zur�ckzusetzen und von vorne zu beginnen
	 * @param player welcher Spieler ist an der Reihe
	 * @param symbol welcher Symbol hat der Spieler, der an der Reihe ist.
	 * @throws RemoteException
	 */
	public void resetSC (int player, String symbol) throws RemoteException;
		
	/**
	 * Hier errechnet der Server, dass das Spiel beendet wurde und gibt
	 * dem HAndler an, wer gewonnen hat.
	 * @param winner wenn 0 --> unentschieden, 1 --> client hat gewonnen, 2 --> client hat verloren
	 * @throws RemoteException
	 */
	public void victorySC (int winner) throws RemoteException;
	
} //interface gameHandle

