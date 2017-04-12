package com.pyj.libapp.resthandlers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pyj.libapp.domain.Book;


import com.pyj.libapp.services.BookService;

@Path("/")
public class BookRestHandler {
	@Autowired
	private BookService bookService;
	private Logger logger = Logger.getLogger(BookRestHandler.class);
	
	@GET
	@Path("book/{name}")
	@Produces("application/xml, application/json")
	public Book getBook(@PathParam("name") String name){
		Book book = null;
		
		try {
			book = bookService.getBookWithName(name);	
		} catch (Exception ex) {
			throw new WebApplicationException(ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
		}
		
		if (book == null) {
			logger.debug("Fail request to lookup book with name : " + name);
		}
		
		return book;
	}
	
	@POST
	@Path("/book")
	@Produces("application/json, application/xml")
	@Consumes("application/json, application/xml")
	public Response addBook(Book newBook) {
		ResponseBuilder respBuilder;
		
		try {
			bookService.addNewBook(newBook);
		} catch (Exception ex) {
			throw new WebApplicationException(ex.getMessage(), Status.INTERNAL_SERVER_ERROR);
		}
		
		logger.debug("Successfully created a new book: " + newBook);
		respBuilder = Response.status(Status.CREATED);
		respBuilder.entity(newBook);
		return respBuilder.build();
	}

}
