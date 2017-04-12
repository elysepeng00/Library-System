package com.pyj.libapp.dao.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.pyj.libapp.dao.BookDao;
import com.pyj.libapp.domain.Book;

@Repository("BookDaoMockImpl")
public class BookDaoMockImpl implements BookDao {
	private ArrayList<Book> bookList;
	
	@PostConstruct
	private void initData() {
		bookList = new ArrayList<Book>();
	}
	
	@Override
	public Book findBookByName(String name){
		for (Book curBook: bookList){
			if (curBook.getName().equals(name)){
				return curBook;
			}
		}
		return null;
	}
	
//	@Override
//	public Book findBookById(long id){
//		for (Book curBook: bookList){
//			if (curBook.getId()==id){
//				return curBook;
//			}
//		}
//		return null;
//	}
	
	@Override
	public List<Book> findBooks(){
		return bookList;
	}
	
	@Override
	public void insertBook(Book book){
		bookList.add(book);
	}
}
