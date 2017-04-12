package com.pyj.libapp.dao;

import java.util.List;

import com.pyj.libapp.domain.Book;

public interface BookDao {
	public Book findBookByName(String name);
	//public Book findBookById(long id);
	public List<Book> findBooks();
	public void insertBook(Book book);
}
