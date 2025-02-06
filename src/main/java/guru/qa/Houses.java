package guru.qa;

import java.util.HashMap;
import java.util.Map;

public class Houses {
	public static void main (String[] args) {
		Houses houses = new Houses();
		houses.addHouse(1, "Магазин");
		houses.removeHouse(2, "Садик");
		houses.printAllHouses();
	}
	Map<Integer, String> houses = new HashMap<>();

	public void addHouse(Integer number, String house) {
		houses.put(number, house);
	}
	public void removeHouse(Integer number, String house){
		do {
			houses.remove(number, house);
		} while (houses.equals(house));
	}
	public void printAllHouses() {
		for (Map.Entry<Integer, String> s : houses.entrySet()) {
			System.out.println(s);
		}
	}
}
