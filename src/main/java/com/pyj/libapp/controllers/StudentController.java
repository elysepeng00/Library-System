package com.pyj.libapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pyj.libapp.domain.Gender;
import com.pyj.libapp.domain.Student;
import com.pyj.libapp.services.StudentService;

/*
     To get to the home page, point your browser to:  http://localhost:8080/courseapp
     or get the new student data form presented directly by going to:  http://localhost:8080/courseapp/newStudentDataForm
*/

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	// Present the student data form
	@RequestMapping(value = "/newStudentDataForm", method = RequestMethod.GET)
	public ModelAndView newStudentDataForm() {
		ModelAndView modelView;
		
 		modelView = new ModelAndView("studentDataForm");
 		modelView.addObject("student", new Student());
		return modelView;
	}
	
	// Process the data the user has entered in the student data form
	@RequestMapping(value = "/processNewStudentProfile", method = RequestMethod.POST)
	public ModelAndView processNewStudentForm(@ModelAttribute("student") @Valid Student student, BindingResult result, HttpSession session) 
	{
		ModelAndView modelView;
		
		if (result.hasErrors()) {
			/*  Re-present the form with error messages */
			modelView = new ModelAndView("studentDataForm");
			return modelView;
		}
		
		studentService.addNewStudent(student);
 		modelView = new ModelAndView("newStudentProfileSuccess");
 		session.setAttribute("student", student);
 		modelView.addObject("student", student);
		
		return modelView;
	}
	
}
