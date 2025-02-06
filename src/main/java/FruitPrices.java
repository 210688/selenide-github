
import java.util.HashMap;
import java.util.Map;

public class FruitPrices {
	public static void main(String[] args) {
		// Создаем словарь, в котором ключ - название фрукта, значение - цена за кг
		Map<String, Double> fruitPrices = new HashMap<>();
		fruitPrices.put("Яблоко", 2.5);
		fruitPrices.put("Груша", 3.0);
		fruitPrices.put("Апельсин", 2.8);
		fruitPrices.put("Банан", 2.3);
		fruitPrices.put("Манго", 4.5);
		fruitPrices.put("Ананас", 5.2);
		fruitPrices.put("Киви", 3.5);
		fruitPrices.put("Персик", 2.9);
		fruitPrices.put("Грейпфрут", 3.2);
		fruitPrices.put("Абрикос", 2.7);

		// Находим фрукт с самой низкой и самой высокой ценой за кг
		String cheapestFruit = "";
		String mostExpensiveFruit = "";
		double minPrice = Double.MAX_VALUE;
		double maxPrice = Double.MIN_VALUE;
		for (Map.Entry<String, Double> entry : fruitPrices.entrySet()) {
			if (entry.getValue() < minPrice) {
				minPrice = entry.getValue();
				cheapestFruit = entry.getKey();
			}
			if (entry.getValue() > maxPrice) {
				maxPrice = entry.getValue();
				mostExpensiveFruit = entry.getKey();
			}
		}

		// Вычисляем стоимость 1 кг разных фруктов
		String fruit1 = "Яблоко";
		String fruit2 = "Груша";
		double fruit1Price = fruitPrices.get(fruit1);
		double fruit2Price = fruitPrices.get(fruit2);

		// Выводим результаты
		System.out.println("Самый дешевый фрукт: " + cheapestFruit);
		System.out.println("Самый дорогой фрукт: " + mostExpensiveFruit);
		System.out.println("Стоимость 1 кг " + fruit1 + ": " + fruit1Price);
		System.out.println("Стоимость 1 кг " + fruit2 + ": " + fruit2Price);
		if (fruit1Price > fruit2Price) {
			System.out.println(fruit1 + " дороже, чем " + fruit2);
		} else if (fruit1Price < fruit2Price) {
			System.out.println(fruit2 + " дороже, чем " + fruit1);
		} else {
			System.out.println("Цены на " + fruit1 + " и " + fruit2 + " одинаковы.");
		}
	}
}
