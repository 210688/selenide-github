package guru.qa;

import java.util.HashMap;
import java.util.Map;

public class Houses {
	public static void main(String[] args) {
		Houses houses = new Houses();
		houses.addHouse(1, "Магазин");
		houses.addHouse(2, "Садик");
		houses.removeHouse(2, "Садик");
		houses.removeHouse(3, "Школа");
		houses.printAllHouses();
		houses.searchHouse(1);
		houses.searchHouse(3);
	}

	Map<Integer, String> houses = new HashMap<>();


	public void addHouse(Integer number, String house) {
		if (!houses.containsKey(number)) {
			houses.put(number, house);
			System.out.println("Дом добавлен: №" + number + " - " + house);
		} else {
			System.out.println("Дом с номером " + number + " уже существует: " + houses.get(number));
		}
	}


	public void removeHouse(Integer number, String house) {
		if (houses.containsKey(number)) {
			String currentHouse = houses.get(number);
			if (currentHouse.equals(house)) {
				houses.remove(number);
				System.out.println("Дом удалён: №" + number + " - " + house);
			} else {
				System.out.println("Дом с номером " + number + " существует, но с другим названием: " + currentHouse);
			}
		} else {
			System.out.println("Дом с номером " + number + " не найден.");
		}
	}


	public void searchHouse(Integer number) {
		if (houses.containsKey(number)) {
			System.out.println("Найден дом: №" + number + " - " + houses.get(number));
		} else {
			System.out.println("Дом с номером " + number + " не найден.");
		}
	}


	public void printAllHouses() {
		System.out.println("Список всех домов:");
		for (Map.Entry<Integer, String> entry : houses.entrySet()) {
			System.out.println("№" + entry.getKey() + " - " + entry.getValue());
		}
	}
}
