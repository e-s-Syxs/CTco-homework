package main;

import java.util.ArrayList;

public class ListModifier {
	private ListCreator listcreator = new ListCreator();
	private ArrayList<Person> uniqueList = new ArrayList<Person>();

	public ArrayList<Person> getUniqueList() {
		return uniqueList;
	}

	public ListModifier() {
		for (int i = 0; i < listcreator.getPersonList().size(); i++) {
			for (int j = i + 1; j < listcreator.getPersonList().size(); j++) {
				if (listcreator.getPersonList().get(j).name.equals(listcreator.getPersonList().get(i).name)) {
					listcreator.getPersonList().get(i).cost = (listcreator.getPersonList().get(i).cost
							+ listcreator.getPersonList().get(j).cost);
					uniqueList.add(listcreator.getPersonList().get(i));

				} else {
					uniqueList.add(listcreator.getPersonList().get(i));
					uniqueList.add(listcreator.getPersonList().get(j));

				}
			}

		}
		int uniqueListSize = uniqueList.size();
		for (int i = 0; i < uniqueListSize - 1; i++) {
			for (int j = i + 1; j < uniqueListSize; j++) {
				if (uniqueList.get(j).name.equals(uniqueList.get(i).name)) {
					uniqueList.remove(j);
					j--;
					uniqueListSize--;
				}
			}
		}

		for (int i = 0; i < uniqueList.size(); i++) {
			Person tempItem = uniqueList.get(i);
			System.out.println(tempItem.name + "'s total expenses " + tempItem.cost + ".");

		}
		System.out.println("The total expense is " + total() + " EUR.");

	}

	public double total() {
		double tempItem = 0;
		double totalSum = 0;
		for (int i = 0; i < uniqueList.size(); i++) {
			tempItem = uniqueList.get(i).cost;
			totalSum = totalSum + tempItem;
		}
		return totalSum;
	}
}
