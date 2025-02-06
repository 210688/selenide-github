package guru.qa;

import java.util.LinkedList;
import java.util.List;

public class BasketballPlayers {
	public static void main(String[] args) {
	BasketballPlayers basketballPlayers = new BasketballPlayers();
		basketballPlayers.addPlayer("Jordan");
		basketballPlayers.searchPlayer("LeBron");
		basketballPlayers.deletePlayer("Jordan");
		basketballPlayers.showAllPlayers();
	}
	public List<String> players = new LinkedList<> ();

	public BasketballPlayers() {
	}

	public void addPlayer(String player) {
		players.add(player);
	}

	public void searchPlayer(String player) {
		for (int i = 0; i < players.size(); i++) {
			if (players.contains(player)) {
				System.out.println("Player found! " + player);
				break;
			} else {
				System.out.println("Player not found! ");
			}
		}
	}

	public void deletePlayer(String player) {
		for (int i = 0; i < players.size(); i++) {
			if (players.contains(player)) {
				players.remove(player);
				break;
			} else {
				System.out.println("Player not found! ");
			}
		}
	}
	public void showAllPlayers() {
		System.out.println("All players " + players);
	}
}
