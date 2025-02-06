import java.util.Scanner;


	public class Сountry {
		public static void main (String[] args) {
			String[] countries = {"Russia", "USA", "China", "Brazil"};
			String[] currencies = {"руб", "$", " yuan", "R$"};
			double[] weights = {1.0, 2.20462, 2.20462, 2.20462};
			double[] price = {100, 200, 300, 400};

			for (int i = 0; i < currencies.length; i++) {
				System.out.println ("1 kg of fruit in " + countries[i] + " price " + price[i] +  " " + currencies[i]);
			}
		}
	}
