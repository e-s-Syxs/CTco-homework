package main;

import java.util.ArrayList;

public class PaymentToEachOther {
	private TransactionsToBeMade tTBM = new TransactionsToBeMade();
	private ArrayList<Person> mustPay = tTBM.getMustPay();
	private ArrayList<Person> mustGetPaid = tTBM.getMustGetPaid();
	private ArrayList<Person> allIsFine = tTBM.getAllIsFine();

	public PaymentToEachOther() {
		int mustPaySize = mustPay.size();
		int mustGetPaidSize = mustGetPaid.size();

		if ((mustPay.size() == 0) && (mustGetPaid.size() == 0)) {
			System.out.println("All is fine noone has to pay anyone!");

		} else {
			while (!(mustPay.size() == 0) && !(mustGetPaid.size() == 0)) {
				for (int i = 0; i < mustPaySize; i++) {
					for (int j = 0; j < mustGetPaidSize; j++) {
						if (mustPay.get(i).bilance > mustGetPaid.get(j).bilance) {
							mustPay.get(i).bilance = mustPay.get(i).bilance - mustGetPaid.get(j).bilance;
							System.out.println(mustPay.get(i).name + " has to pay " + mustGetPaid.get(j).bilance
									+ " EUR to " + mustGetPaid.get(j).name + ".");
							allIsFine.add(mustGetPaid.get(j));
							mustGetPaid.remove(j);

							mustGetPaidSize--;
						} else if (mustPay.get(i).bilance < mustGetPaid.get(j).bilance) {
							mustGetPaid.get(j).bilance = mustGetPaid.get(j).bilance - mustPay.get(i).bilance;
							System.out.println(mustPay.get(i).name + " has to pay " + mustPay.get(i).bilance
									+ " EUR to " + mustGetPaid.get(j).name + ".");

							allIsFine.add(mustPay.get(i));
							mustPay.remove(i);
							mustPaySize--;
						} else {
							System.out.println(mustPay.get(i).name + " has to pay " + mustGetPaid.get(j).bilance
									+ " EUR to " + mustGetPaid.get(j).name + ".");
							allIsFine.add(mustPay.get(i));
							allIsFine.add(mustGetPaid.get(j));
							mustPay.remove(i);
							mustGetPaid.remove(j);

							mustPaySize--;
							mustGetPaidSize--;
						}

					}

				}
			}

		}
	}
}
