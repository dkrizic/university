package com.prodyna.pac.university.student;

import java.util.List;

import com.prodyna.pac.university.course.Course;

public interface StudentService {
	Student createStudent( Student s );
	List<Student> listAllStudents();
	void assignCourseToStudent( Course c, Student s );
}
