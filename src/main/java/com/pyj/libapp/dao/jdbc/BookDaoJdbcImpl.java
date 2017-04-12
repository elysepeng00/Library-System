package com.pyj.libapp.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.pyj.libapp.dao.BookDao;
import com.pyj.libapp.domain.Book;


@Repository("BookDaoJdbcImpl")
public class BookDaoJdbcImpl implements BookDao {
	@Autowired
	private DataSource dataSource;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private BookRowMapper bookRowMapper;

	@PostConstruct
	public void setup() {
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource);
		jdbcInsert.withTableName("book");
		jdbcInsert.usingGeneratedKeyColumns("id");
		jdbcInsert.usingColumns("name","author");
		
		bookRowMapper = new BookRowMapper();
	}
	
//	@Override
//	public Book findBookById(long id) {
//		String sql = "SELECT * FROM book WHERE id = :id";
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
//		List<Book> matchingBooks = dbTemplate.query(sql, params, bookRowMapper);
//		if (matchingBooks.size() != 1) {
//			return null;  /* student with requested id was not found  */
//		}
//
//		return matchingBooks.get(0);
//	}
	
	@Override
	public Book findBookByName(String name) {
		String sql = "SELECT * FROM book WHERE name = :name";
		MapSqlParameterSource params = new MapSqlParameterSource("name", name);
		List<Book> matchingBooks = dbTemplate.query(sql, params, bookRowMapper);
		if (matchingBooks.size() != 1) {
			return null;  /* student with requested id was not found  */
		}

		return matchingBooks.get(0);
	}
	
	@Override
	public List<Book> findBooks() {
		String sql = "SELECT * FROM book";
		List<Book> bookList = dbTemplate.query(sql, bookRowMapper);
		return bookList;
	}
	
//	/*   Student has an enumeration data member so we can't use BeanPropertySqlParameterSource.
//	 *   Instead, we'll generate our own Map from the data members.
//	 */
//	public Map<String, Object> getBookParams(Book book) {
//		Map<String, Object> bookParams = new HashMap<String, Object>();
//		
//		
//		bookParams.put("name", book.getName());
//		bookParams.put("author", book.getAuthor());
//		
//		return bookParams;
//	}
//	
//	@Override
//	public void insertBook(Book book) {
//		long id;
//		Map<String, Object> bookParams = getBookParams(book);
//		Number newId = jdbcInsert.executeAndReturnKey(bookParams);
//		id = newId.longValue();
//		book.setId(id);
//	}
	
	@Override
	public void insertBook(Book book){
		long id;
		SqlParameterSource params = new BeanPropertySqlParameterSource(book);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		id = newId.longValue();
		book.setId(id);
	}
}
