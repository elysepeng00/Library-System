package com.pyj.libapp.dao;

import java.util.List;

import com.pyj.libapp.domain.Student;

public interface StudentDao {
	public Student findStudentFromId(long id);
	public List<Student> findStudents();
	public void insertStudent(Student stud);
}
