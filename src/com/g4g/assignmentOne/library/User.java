package com.g4g.assignmentOne.library;

import java.util.List;

public class User {
	private long id;
	private String firstName;
	private String Lastname;
	private String address;
	private List<Book> reservedBooks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getReservedBooks() {
		return reservedBooks;
	}

	public void setReservedBooks(List<Book> reservedBooks) {
		this.reservedBooks = reservedBooks;
	}
}
