package guru.qa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class City {
	public static void main (String[] args) {
		City city = new City();
		city.addCity("Донецк");
		city.removeCity("Ростов");
		city.searchCity();
	}
	public Set<String> city = new HashSet<> ();

	public void addCity (String cityName) {
		city.add (cityName);
	}

	public void removeCity(String cityName) {
		city.remove (cityName);
	}

	public void searchCity() {
		Iterator<String> it = city.iterator ();

		while (it.hasNext ()) {
			String resulSearchCity = it.next ();
			System.out.println (resulSearchCity);
		}
	}
}
