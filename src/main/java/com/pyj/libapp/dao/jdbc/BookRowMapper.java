package com.pyj.libapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pyj.libapp.domain.Book;

public class BookRowMapper implements RowMapper<Book>{
	public Book mapRow(ResultSet resultSet, int row) throws SQLException {
		String name, author;
		int id;
		Book book;
		
		name = resultSet.getString("name");
		author = resultSet.getString("author");
		id = resultSet.getInt("id");
		
		book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setId(id);
		
		return book;
	}

}
