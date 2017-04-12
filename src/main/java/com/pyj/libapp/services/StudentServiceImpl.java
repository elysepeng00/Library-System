package com.pyj.libapp.services;

import com.pyj.libapp.domain.Student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pyj.libapp.dao.StudentDao;
import com.pyj.libapp.domain.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	@Qualifier("StudentDaoJdbcImpl")
	//@Qualifier("StudentDaoMockImpl")
	private StudentDao studentDao;
	
	@Override
	public void addNewStudent(Student stud) {
		studentDao.insertStudent(stud);
	}
	
	@Override
	public void addTwoStudents(Student stud1, Student stud2) {
		studentDao.insertStudent(stud1);
		studentDao.insertStudent(stud2);
	}

	@Override
	public Student getStudentWithId(int studId) {
		return studentDao.findStudentFromId(studId);
		
	}

	@Override
	public List<Student> getStudentList() {
		return studentDao.findStudents();
	}
}
