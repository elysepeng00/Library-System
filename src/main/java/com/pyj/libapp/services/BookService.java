package com.pyj.libapp.services;

import java.util.List;

import com.pyj.libapp.domain.Book;

public interface BookService {
	public Book getBookWithName(String name);
	//public Book getBookWithId(int bookId);
	public List<Book> getBookList();
	public void addNewBook(Book book);
	public void addTwoBooks(Book book1, Book book2);
}
