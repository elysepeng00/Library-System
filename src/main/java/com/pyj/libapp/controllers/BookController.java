package com.pyj.libapp.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pyj.libapp.domain.Book;
import com.pyj.libapp.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value = "/listBooks", method = RequestMethod.GET)
	public ModelAndView bookList(String bookName) {	
		logger.info("List all the books, search book by name");
		
		List<Book> bookList;
		ModelAndView modelView;
		
		bookList = bookService.getBookList();
		modelView = new ModelAndView("viewBookList");
		modelView.addObject("bookList",bookList);
		
		return modelView;
	}
	
	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public ModelAndView bookSearched(String bookName) {	
		logger.info("Book information");
		
		ModelAndView modelView;
		Book bookToSearch;
		
		bookToSearch = bookService.getBookWithName(bookName);
		modelView = new ModelAndView("viewBook");
		//modelView.addObject("bookName",bookName);
		modelView.addObject("bookToSearch",bookToSearch);
		
		return modelView;
	}
	
}
