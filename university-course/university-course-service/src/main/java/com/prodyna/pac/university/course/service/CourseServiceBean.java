package com.prodyna.pac.university.course.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.prodyna.pac.university.course.Course;
import com.prodyna.pac.university.course.CourseService;

@Stateless
public class CourseServiceBean implements CourseService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Course addCourse(Course c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Course> readCourses() {
		return em.createQuery("select c from Course c", Course.class)
				.getResultList();
	}

	@Override
	public Course updateCourse(Course c) {
		return em.merge( c );
	}

	@Override
	public void deleteCourse(long id) {
		Course c = em.find( Course.class, id );
		em.remove( c );
	}

}
