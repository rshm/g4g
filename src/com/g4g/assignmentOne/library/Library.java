package com.g4g.assignmentOne.library;

import java.util.List;

public class Library {
	List<Book> books;
	List<User> users;
	String address;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
