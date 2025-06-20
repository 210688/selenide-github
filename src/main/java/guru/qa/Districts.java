package guru.qa;

import java.util.ArrayList;

public class Districts {
	public static void main (String[] args) {
		Districts districts = new Districts();
		districts.addDistrict("Ленинский");
		districts.addDistrict("Ворошиловский");
		districts.deletedDistrict("Ворошиловский");
		districts.deletedDistrict("Кировский");
		districts.printAllDistricts();
	}

	ArrayList<String> districts = new ArrayList<>();

	public void addDistrict(String district) {
		if (!districts.contains(district)) {
			districts.add(district);
			System.out.println("Район добавлен: " + district);
		} else {
			System.out.println("Район уже существует: " + district);
		}
	}

	public void deletedDistrict(String district) {
		boolean removed = districts.remove(district);
		if (removed) {
			System.out.println("Район удалён: " + district);
		} else {
			System.out.println("Район не найден: " + district);
		}
	}

	public void printAllDistricts() {
		System.out.println("Список районов:");
		for (String s : districts) {
			System.out.println(s);
		}
	}
}