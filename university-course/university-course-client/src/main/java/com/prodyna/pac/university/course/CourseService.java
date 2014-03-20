package com.prodyna.pac.university.course;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * CRUD interface for course.
 *
 * @author dkrizic
 */
@Local
@Path("/course")
@Produces("application/json")
@Consumes("application/json")
public interface CourseService {

    @POST
    public Course addCourse(Course c);

    @GET
    public List<Course> readCourses();

    @PUT
    public Course updateCourse(Course c);

    @DELETE
    @Path("{cid}")
    public void deleteCourse( @PathParam("cid") long id);
}
