package com.g4g.assignmentOne;
/**
 * You are given an array of Persons. You have to do the following operation until you are left with 1 element in the array. In the end, you have to return the minimum sum of all the operation values
 *
 * The operation to do → Pick any two Person from the array, calculate the sum of their heights and then delete that person and add one person with the newly added height
 * The sum of two persons’ heights is the operation value
 * For example, let’s assume we have heights of people as :
 * 1, 2, 3, 4
 *
 Way 1:

 Pick 2, 3 Operation Value - 5, arr becomes - {1, 4, 5}
 Pick 4, 5, Operation Value - 9, arr becomes - {1, 9}
 Pick 1, 9 - Operation Value - 10, arr becomes {10}

 Ans = 5 + 9 + 10 = 24

 Way 2:
 Pick 1, 2 Operation Value - 3, arr becomes - {3, 3, 4}
 Pick 3, 3 Operation Value - 6, arr becomes - {4, 6}
 Pick 4, 6 Operation Value - 10, arr becomes - {10}

 Ans = 3 + 6 + 10 = 19

 19 is the minimum operation sum value that we can achieve so for this example, we should 19

 */

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
	static boolean foo(char c)
	{
		System.out.print(c);
		return true;
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

}
