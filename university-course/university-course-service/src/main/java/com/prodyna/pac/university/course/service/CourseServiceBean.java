package com.prodyna.pac.university.course.service;

import com.prodyna.pac.university.course.Course;
import com.prodyna.pac.university.course.CourseService;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class CourseServiceBean implements CourseService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Override
    public Course addCourse(Course c) {
        em.persist(c);
        log.info("Added " + c);
        return c;
    }

    @Override
    public List<Course> readCourses() {
        return em.createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    @Override
    public Course updateCourse(Course c) {
        return em.merge(c);
    }

    @Override
    public void deleteCourse(long id) {
        Course c = em.find(Course.class, id);
        em.remove(c);
    }

}
