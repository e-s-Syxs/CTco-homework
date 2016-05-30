package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ListCreator {

	ArrayList<Person> personList = new ArrayList<Person>();
	Scanner scanName = new Scanner(System.in);
	Scanner scanExpense = new Scanner(System.in);
	Scanner scanCost = new Scanner(System.in);
	Scanner areYouDone = new Scanner(System.in);

	public ArrayList<Person> getPersonList() {
		return personList;
	}

	public ListCreator() {

		while (true) {

			Person person = new Person();
			System.out.println("Enter name!");
			person.name = scanName.nextLine();

			System.out.println("Enter expense!");
			person.expense = scanExpense.nextLine();

			System.out.println("Enter cost in eur!");
			person.cost = scanCost.nextInt();

			personList.add(person);
			System.out.println("Are you done entering people? Yes ='Y' or any button to continue!");
			String yOrN = areYouDone.nextLine();
			if (yOrN.equals("Y")) {
				break;
			}
		}

		for (int i = 0; i < personList.size(); i++) {
			Person tempItem = personList.get(i);
			System.out.println(
					tempItem.name + " has paid for " + tempItem.expense + " and it cost " + tempItem.cost + " EUR.");
		}
		System.out.println("");

	}

}
