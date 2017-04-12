package com.pyj.libapp.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pyj.libapp.domain.Gender;
import com.pyj.libapp.domain.Student;

public class StudentRowMapper implements RowMapper<Student> {
	static final Gender genderNames[] = Gender.values(); /* Generate this only once */

	public Student mapRow(ResultSet resultSet, int row) throws SQLException {
		String lastName, firstName;
		int age, id;
		Student stud;
		int genderIntVal;
		Gender genderVal;
		
		lastName = resultSet.getString("lastName");
		firstName = resultSet.getString("firstName");
		age = resultSet.getInt("age");
		id = resultSet.getInt("id");
		
		/* Convert ordinal (number) to enumeration name */
		genderIntVal = resultSet.getInt("gender");
		genderVal = genderNames[genderIntVal];  
		
		stud = new Student();
		stud.setFirstName(firstName);
		stud.setLastName(lastName);
		stud.setAge(age);
		stud.setId(id);
		stud.setGender(genderVal);
		
		return stud;
	}

}
