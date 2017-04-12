package com.pyj.libapp.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pyj.libapp.dao.BookDao;
import com.pyj.libapp.domain.Book;



@ContextConfiguration("classpath:courseapp-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoTest {
	@Autowired
	@Qualifier("BookDaoJdbcImpl")
	//@Qualifier("BookDaoMockImpl")
	private BookDao bookDao;
	private Book bookToLookup;
	private String bookname = "JavaScript";
	private String bookauthor = "Thomas";
	private int bookid = 1;
	
	@Before
	public void init() {
		bookToLookup = new Book(); 
		bookToLookup.setName("JavaScript");
		bookToLookup.setAuthor("Thomas");
		bookToLookup.setId(1);
		
	}
	
	@Test
	public void testFindBookWithName() {
		//bookDao.insertBook(bookToLookup);
		String testName= "JavaScript";
		Book retrievedBook = bookDao.findBookByName(testName);
		System.out.println("retrievedBook name is " + retrievedBook.getName());
		System.out.println("retrievedBook id is " + retrievedBook.getId());
		assertEquals(bookname,retrievedBook.getName());
		assertEquals(bookauthor,retrievedBook.getAuthor());
		assertEquals(bookid,retrievedBook.getId());
	}
	
//	@Test
//	public void testFindBookWithId() {
//		int testId = 1;
//		Book retrievedBook = bookDao.findBookById(testId);
//		
//		System.out.println("retrievedBook name is " + retrievedBook.getName());
//		System.out.println("retrievedBook author is " + retrievedBook.getAuthor());
//		System.out.println("retrievedBook id is " + retrievedBook.getId());
//		assertEquals(bookname,retrievedBook.getName());
//		assertEquals(bookauthor,retrievedBook.getAuthor());
//		assertEquals(bookid,retrievedBook.getId());
//	}
	
	@Test
	public void testInsertBook() {
		Book bookToInsert;
		bookToInsert = new Book(); 
		bookToInsert.setName("Data Structure");
		bookToInsert.setAuthor("V.V.Muniswamy");
		String nameOfInsertedBook;
		//long idOfInsertedBook;
		bookDao.insertBook(bookToInsert);
		nameOfInsertedBook = bookToInsert.getName();
		//idOfInsertedBook = bookToInsert.getId();
		Book retrievedBook = bookDao.findBookByName(nameOfInsertedBook);
		//Book retrievedBook = bookDao.findBookById(idOfInsertedBook);
		assertEquals(retrievedBook,bookToInsert);
	}
	
}
