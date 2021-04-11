package com.g4g.assignmentTwo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Assignment 1 (Streams)
 * <p>
 * Instructions:
 * <p>
 * Try to attempt all the questions given below. Most of them would require only 1 single line code, some might require 2-3 lines as well
 * All the questions need to be answered using Java Streams, not in the general looping way
 * <p>
 * <p>
 * For the first seven questions below, you will need this Person.java class, so create this one class and then attempt questions
 */

public class PersonStream {

	private int age;
	private String name;
	private String country;

	public PersonStream(int age, String name, String country) {
		this.age = age;
		this.name = name;
		this.country = country;
	}

	public static void main(String[] args) {

		List<PersonStream> people = Arrays.asList(
				new PersonStream(20, "John", "USA"),
				new PersonStream(35, "Sam", "Italy"),
				new PersonStream(15, "Jamie", "England"),
				new PersonStream(30, "Robert", "Italy"),
				new PersonStream(20, "James", "Ireland"),
				new PersonStream(25, "Peter", "USA"),
				new PersonStream(5, "Jessica", "Norway"),
				new PersonStream(40, "Roger", "Netherlands"),
				new PersonStream(5, "ttr", "Netherlands"),
				new PersonStream(50, "Jim", "USA"));

		//1. average
		Double average = people.stream()
				.mapToInt(x -> x.age)
				.average()
				.getAsDouble();
		System.out.printf("Average age: " + average);

		//2.  people.age>20 || vowel in name
		System.out.println("PEople with age>20 or vowels in their name");

		people.stream()
				.filter(x -> checkForVowels(x.getName()))
				.filter(x -> x.age > 20)
				.forEach(System.out::println);

		//3. sort list in ascending , same age sort descending order of name
		System.out.println("sort list in ascending , same age sort descending order of name");
		Comparator<PersonStream> compareByName = Comparator.comparing(PersonStream::getName);
		Collections.sort(people, Comparator.comparing(PersonStream::getAge)
				.thenComparing(compareByName.reversed()));
		for (PersonStream p : people) {
			System.out.println("name: " + p.name + " Age: " + p.age);
		}

		//4. Key:value: CountryName:Count
		System.out.println("Map of country name and count");
		Map<String, Long> map = people.stream()
									  .collect(Collectors.groupingBy(PersonStream::getCountry, Collectors.counting()));
		System.out.println("Map is: " + map);

		System.out.println("Map CountryName:AveragingAge: ");
		Map<String,Double> countryAge = people.stream()
											  .collect(Collectors.groupingBy(PersonStream::getCountry,Collectors.averagingDouble(PersonStream::getAge)));
		System.out.println("countryAge Map is: " + countryAge);

		System.out.println("Print the oldest person in every country");
		Map<String, Optional<PersonStream>> countryOldestPerson = people.stream()
																		.collect(Collectors.groupingBy(PersonStream::getCountry,Collectors.maxBy(Comparator.comparing(PersonStream::getAge))));
		System.out.println("countryOldestPerson Map is: " + countryOldestPerson);

		System.out.println("Print the country with most people");
		System.out.println(map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)));

		System.out.println("Create a list of 20 random integers in the range 0 - 1000 using Java 8 streams");
		Random rand = new Random();
		rand.ints(20,0,1001).forEach(System.out::println);
	}

	public static boolean checkForVowels(String name) {
		boolean vowel = false;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			switch (ch) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowel = true;
					break;
				default:
					vowel = false;
					break;
			}
			if (vowel) {
				break;
			}
		}
		return vowel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return name;

	}

}

/**
 * Q1. Print the avg age of all the people
 * Q2. Create a list of all the people who are either greater than 20 or contain any vowel in their name (uppercase or lowercase)
 * Q3. Create a list of people, sorted in ascending order on the basis of age, if age is the same then sort in descending order of name
 * Q4. Create a map from this people list where the key is country name and value is count which means a map will tell how many people live in a particular country
 * Q5. Create a map which stores avg age of people per country (key should be country and value should be average age i.e, double)
 * Q6. Print the oldest person in every country
 * Q7. Print the country with most people
 * Q8. Create a list of 20 random integers in the range 0 - 1000 using Java 8 streams
 */
