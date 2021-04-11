package com.g4g.assignmentOne.library;

public interface LibraryManagement {
	public boolean reserveBook(Book book, User user);
	public boolean returnBook(Book book,  User user);
	public boolean isBookAvailable(Book book);

}
