package com.prodyna.pac.university.course;

import java.util.List;

import javax.ejb.Local;

/**
 * CRUD interface for course.
 * 
 * @author dkrizic
 */
@Local
public interface CourseService {
	public Course addCourse( Course c );
	public List<Course> readCourses();
	public Course updateCourse( Course c );
	public void deleteCourse( long id );
}
