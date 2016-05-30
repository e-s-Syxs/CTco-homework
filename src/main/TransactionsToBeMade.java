package main;

import java.util.ArrayList;

public class TransactionsToBeMade {
	private ListModifier transactions = new ListModifier();
	private ArrayList<Person> personList = transactions.getUniqueList();
	private ArrayList<Person> mustPay = new ArrayList<Person>();
	private ArrayList<Person> mustGetPaid = new ArrayList<Person>();
	private ArrayList<Person> allIsFine = new ArrayList<Person>();

	public ArrayList<Person> getAllIsFine() {
		return allIsFine;
	}

	public ArrayList<Person> getMustPay() {
		return mustPay;
	}

	public ArrayList<Person> getMustGetPaid() {
		return mustGetPaid;
	}

	public TransactionsToBeMade() {
		System.out.println("Average: " + round() + " EUR to be paid by eash person.");
		System.out.println("");
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).cost < round()) {
				personList.get(i).bilance = round() - personList.get(i).cost;
				mustPay.add(personList.get(i));
			} else if (personList.get(i).cost > round()) {
				personList.get(i).bilance = personList.get(i).cost - round();
				mustGetPaid.add(personList.get(i));
			} else {
				allIsFine.add(personList.get(i));
			}
		}

	}

	public double totalCost() {
		double tempItem = 0;
		double totalSum = 0;
		for (int i = 0; i < personList.size(); i++) {
			tempItem = personList.get(i).cost;
			totalSum = totalSum + tempItem;
		}
		return totalSum;
	}

	public double round() {
		double tempItem = totalCost() / personList.size();
		double roundOff = Math.round(tempItem * 100.0) / 100.0;
		return roundOff;
	}
}
