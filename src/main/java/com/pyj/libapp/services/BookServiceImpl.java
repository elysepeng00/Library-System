package com.pyj.libapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyj.libapp.dao.BookDao;
import com.pyj.libapp.domain.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	@Qualifier("BookDaoJdbcImpl")
	//@Qualifier("BookDaoMockImpl")
	private BookDao bookDao;
	
	@Override
	public Book getBookWithName(String name){
		return bookDao.findBookByName(name);
	}
	
//	@Override
//	public Book getBookWithId(int bookId){
//		return bookDao.findBookById(bookId);
//	}
	
	@Override
	public List<Book> getBookList(){
		return bookDao.findBooks();
	}
	
	@Override
	public void addNewBook(Book book){
		bookDao.insertBook(book);
		
	}
	
	@Override
	public void addTwoBooks(Book book1, Book book2){
		bookDao.insertBook(book1);
		bookDao.insertBook(book2);
	}
}
