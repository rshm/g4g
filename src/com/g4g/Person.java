package com.g4g;

import java.util.ArrayList;
import java.util.List;

public class Person {
	int id;
	private int age;

	Person(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		// write your code here
		Person one = new Person(3);
		Person two = new Person(2);
		Person three = new Person(1);
		Person four = new Person(4);

		List<Person> person = new ArrayList<>();
		person.add(one);
		person.add(two);
		person.add(three);
		person.add(four);
		System.out.println(findMinimumOperationSum(person));
	}

	public static int findMinimumOperationSum(List<Person> personList) {
		int currentMinSum = 0;
		if (personList.size() == 0) {
			return 0;
		}
		if (personList.size() < 3) {
			printList(personList);
			for (Person x : personList) {
				currentMinSum = currentMinSum + x.id;
			}
			System.out.println("List size limit currentMinSum: " + currentMinSum);
			return currentMinSum;
		}
		int i = 1;
		printList(personList);
		if ((i + 1) < personList.size() && personList.get(i - 1).id > personList.get(i + 1).id) {
			System.out.println("Choosing Right  i=" + (i + 1));
			currentMinSum = personList.get(i).id + personList.get(i + 1).id;
			personList.get(i).id = currentMinSum;
			personList.remove(i + 1);
		} else {
			System.out.println("Choosing Left i=" + (i - 1));
			currentMinSum = personList.get(i).id + personList.get(i - 1).id;
			personList.get(i).id = currentMinSum;
			personList.remove(i - 1);
		}
		System.out.println("currentMinSum: " + currentMinSum);
		return currentMinSum + findMinimumOperationSum(personList);
	}

	public static void printList(List<Person> p) {
		for (Person x : p) {
			System.out.print(x.id + " ");
		}
		System.out.println();
	}

	public void someLogic() {
		// write your code here
		//        for (int i = 1; i < personList.size(); i++) {
		//            printList(personList);
		//            System.out.println("\n i ="+i);
		//            if ((i + 1) < personList.size() && personList.get(i - 1).id > personList.get(i + 1).id) {
		//                System.out.println("Choosing Right  i="+(i+1));
		//                currentMinSum = personList.get(i).id + personList.get(i + 1).id;
		//                personList.get(i + 1).id = Integer.MAX_VALUE;
		//                personList.get(i).id = currentMinSum;
		//                i++;
		//            } else {
		//                System.out.println("Choosing Left i="+(i-1));
		//                currentMinSum = personList.get(i).id + personList.get(i - 1).id;
		//                personList.get(i - 1).id = Integer.MAX_VALUE;
		//                personList.get(i).id = currentMinSum;
		//            }
		//
		//            globalSum += currentMinSum;
		//        }

	}
}
