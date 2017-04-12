package com.pyj.libapp.services;

import java.util.List;

import com.pyj.libapp.domain.Student;

public interface StudentService {
	public Student getStudentWithId(int studId);
	public List<Student> getStudentList();
	public void addNewStudent(Student stud);
	public void addTwoStudents(Student stud1, Student stud2);
}
