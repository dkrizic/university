package com.prodyna.pac.university.course;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

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
	public void simpleTest() {
		assertEquals( 0, cs.readCourses().size() );
		Course c0 = new Course();
		c0.setName("Informatics");
		c0.setDescription("Super course");
		Course c1 = cs.addCourse(c0);
		Assert.assertNotNull( c1.getId() );
		assertEquals( 1, cs.readCourses().size() );
		cs.deleteCourse( c1.getId() );
		assertEquals( 0, cs.readCourses().size() );
	}
	
}
