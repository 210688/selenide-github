public class Main {
	public static void main (String[] args) {

		// математические операторы

		int apple = 10; // цена
		int banana = 20;
		int orange = 40;
		int grape = 50;
		int pear = 60;
		int apricot = 30;
		int cherry = 15;
		int watermelon = 70;
		int mandarin = 80;
		int cherries = 90;
		System.out.println("apple + banana = " + (apple + banana));
		System.out.println ("orange - grape = " + (orange - grape));
		System.out.println ("pear * apricot = " + (pear * apricot));
		System.out.println ("cherry / watermelon = " + (cherry / watermelon));
		System.out.println ("--mandarin = " + (--mandarin));
		System.out.println ("++mandarin = " + (++mandarin));
		System.out.println ("cherries++ = " + (cherries++));
		System.out.println ("apricot-- = " + (apricot--));

		// логические операторы

		int apple1 = 100; // граммы
		int banana1 = 200;
		int orange1 = 400;
		int grape1= 500;
		int pear1 = 600;
		int apricot1 = 300;
		int cherry1 = 150;
		int watermelon1 = 700;
		int mandarin1 = 800;
		int cherries1 = 900;
		System.out.println("apple1 < banana1 = " + (apple1 < banana1));
		System.out.println("cherries1 > mandarin1 = " + (cherries1 > mandarin1));
		System.out.println("orange1 == grape1 = " + (orange1 == grape1));
		System.out.println("pear1 >= apricot1 = " + (pear1 >= apricot1));
		System.out.println("cherry1 <= watermelon1 = " + (cherry1 <= watermelon1));
		System.out.println("orange1 != grape1 = " + (orange1 != grape1));

		//переполнения при вычислениях
		byte byteVar = 126;
        int intNumber = 214748365;
		System.out.println((byte) (byteVar + 2));
		System.out.println(intNumber + 2);


		//вычисления комбинаций типов данных (int и double)
		int varInt = 370;
		double varDouble = 30.8;
		System.out.println( "varInt + varDouble: " + (varInt + varDouble));
		System.out.println("varInt - varDouble: " + (varInt - varDouble));
	}
}