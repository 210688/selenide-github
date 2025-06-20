package guru.qa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class City {
	public static void main (String[] args) {
		City city = new City();
		city.addCity("Донецк");
		city.addCity("Ростов");
		city.removeCity("Ростов");
		city.removeCity("Москва");
		city.searchCity();
	}

	public Set<String> city = new HashSet<> ();

	public void addCity (String cityName) {
		boolean added = city.add(cityName);
		if (added) {
			System.out.println("Город добавлен: " + cityName);
		} else {
			System.out.println("Город уже существует: " + cityName);
		}
	}

	public void removeCity(String cityName) {
		boolean removed = city.remove(cityName);
		if (removed) {
			System.out.println("Город удалён: " + cityName);
		} else {
			System.out.println("Город не найден: " + cityName);
		}
	}

	public void searchCity() {
		System.out.println("Список городов:");
		Iterator<String> it = city.iterator();

		while (it.hasNext()) {
			String resulSearchCity = it.next();
			System.out.println(resulSearchCity);
		}
	}
}