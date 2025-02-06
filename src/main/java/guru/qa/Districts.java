package guru.qa;

import java.util.ArrayList;

public class Districts {
	public static void main (String[] args) {
		Districts districts = new Districts();
		districts.addDistrict("Ленинский");
		districts.deletedDistrict("Ворошиловский");
		districts.printAllDistricts();
	}
	ArrayList<String> districts = new ArrayList<>();

	public void addDistrict(String district) {
		districts.add(district);
	}

	public void deletedDistrict(String district) {
		districts.remove(district);
	}

	public void printAllDistricts() {
		for (String s : districts) {
			System.out.println(s);
		}
	}
}
