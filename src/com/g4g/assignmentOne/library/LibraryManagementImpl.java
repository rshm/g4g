package com.g4g.assignmentOne.library;

public class LibraryManagementImpl implements LibraryManagement {
	@Override
	public boolean reserveBook(Book book, User user) {
		return (user.getReservedBooks().add(book));
	}

	@Override
	public boolean returnBook(Book book, User user) {
		return (user.getReservedBooks().remove(book));
	}

	@Override
	public boolean isBookAvailable(Book book) {
		return !book.isReserved();
	}
}
