package com.prodyna.pac.university.course;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(Arquillian.class)
public class CourseTest {

	@Inject
	private CourseService cs;

    @Deployment
    public static WebArchive createDeployment() {
    	WebArchive wa = ShrinkWrap.create( WebArchive.class, "test.war");
    	wa.addPackages( true,  "com.prodyna.pac.university.course");
    	wa.addAsResource( "persistence.xml", "META-INF/persistence.xml");
    	System.out.println( wa.toString( true ) );
    	return wa;
    }

    @Test
    @InSequence(1)
    public void emptyDatabase() {
        List<Course> courses = cs.readCourses();
        for( Course course : courses ) {
            cs.deleteCourse( course.getId() );
        }
        assertEquals( 0, cs.readCourses().size() );
    }

    @Test
    @InSequence(2)
    public void addCourse() {
        Course c0 = new Course();
        c0.setName("Informatics");
        c0.setDescription("Super course");
        Course c1 = cs.addCourse(c0);
        Assert.assertNotNull( c1.getId() );
        assertEquals( 1, cs.readCourses().size() );
    }

	@Test
    @InSequence(3)
	public void simpleTest() {
        List<Course> courses = cs.readCourses();
        assertEquals( 1, courses.size() );
		cs.deleteCourse( courses.get(0).getId() );
		assertEquals( 0, cs.readCourses().size() );
	}
	
}
