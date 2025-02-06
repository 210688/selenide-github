

public class Java {
	public static void main (String[] args) {

		String[] fruits = new String[]{"Яблоко", "Груша", "Банан", "Апельсин", "Мандарин", "Вишня", "Виноград", "Абрикос", "Айва", "Черешня"};
		double[] fruitPrices = new double[]{8.2, 1.5, 2.3, 4, 9, 7.5, 8.3, 9, 5, 6};
		double[] highestPricePerKg = new double[]{300, 400, 500, 600, 700, 350, 800, 900, 100, 250};
		String[] countries = {"Russia", "USA", "China", "Brazil"};
		String[] currencies = {"руб", "$", " yuan", "R$"};

		double minPrice = Double.MAX_VALUE;
		String cheapestFruit = "";

		for (int i = 0; i < fruitPrices.length; i++) {
			if (fruitPrices[i] < minPrice) {
				minPrice = fruitPrices[i];
				cheapestFruit = fruits[i];
			}
		}
		System.out.println ("Самый дешевый фрукт: " + cheapestFruit);

		double maxPrice = Double.MIN_VALUE;
		String mostExpensiveFruit = "";
		for (int i = 0; i < highestPricePerKg.length; i++) {
			if (highestPricePerKg[i] > maxPrice) {
				maxPrice = fruitPrices[i];
				mostExpensiveFruit = fruits[i];
			}
		}
		System.out.println ("Фрукт с наибольшей стоимостью за килограмм: " + mostExpensiveFruit);

		for (int i = 0; i < currencies.length; i++) {
			System.out.println ("1 kg of fruit in " + countries[i] + " fruitPrices " + fruitPrices[i] + " "
					+ currencies[i]);

		}
	}
}




