package org.training.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.training.dao.EventDAO;
import org.training.dao.UserDAO;
import org.training.model.Event;
import org.training.model.User;

@Path("/tc")
public class TCResource {

	UserDAO udao = new UserDAO();
	EventDAO edao = new EventDAO();

	/*----------------------------------------user----------------------------------------*/

	@GET
	@Path("/user")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> findAllUsers() {
		System.out.println("findAll");
		return udao.findAll();
	}

	@GET
	@Path("/user/searche/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findByEmail(@PathParam("email") String email) {
		System.out.println("findByEmail: " + email);
		return udao.findByEmail(email);
	}

/*	@GET
	@Path("/user/auth/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findAuth(@PathParam("email") String email) {
		System.out.println("findByEmail: " + email);
		return udao.findPass(email);
	}*/

	@GET
	@Path("/user/auth/{email},{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findAuth(@PathParam("email") String email,@PathParam("password") String pass) {
		System.out.println("findByEmail: " + email);	
		return udao.findRole(email,pass);
	}
	 

	@POST
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createUser(User user) {
		System.out.println("create user");
		System.out.println("name is" + user.getFirstName());
		return udao.create(user);
	}

	@PUT
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(User user) {
		user.setFirstName(user.getFirstName());
		System.out.println("Updating user: " + user.getFirstName());
		udao.update(user);
		return user;
	}

	@DELETE
	@Path("/user/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> removeUser(@PathParam("email") String email) {
		System.out.println("Deleted id : " + email);
		udao.remove(email);
		return udao.findAll();
	}

/*	@DELETE
	@Path("/user/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void removeUser(@PathParam("email") String email) {
		System.out.println("Deleted id : " + email);
		udao.remove(email);
	}*/

	/*-----------------------------------------user-------------------------------------------*/

	/*@POST
	@Path("/show")
	public Response addUser(@FormParam("fname") String name,

	@FormParam("lname") int age) {
		return Response.status(200)
				.entity("addUser is called, name : " + name + ", lname : "+ age).build();
	}*/

	/*----------------------------------------event----------------------------------------*/

	@GET
	@Path("/event")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findAll() {
		System.out.println("findAll");
		return edao.findAll();
	}

	@GET
	@Path("/event/searchid/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findById(@PathParam("id") int id) {
		System.out.println("findById: " + id);
		return edao.findById(id);
	}

	@GET
	@Path("/event/searchd/{date}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByDate(@PathParam("date") String date) {
		System.out.println("findByDate: " + date);
		return edao.findByDate(date);
	}

	@GET
	@Path("/event/searchg/{group}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByGroup(@PathParam("group") String group) {
		System.out.println("findByGroup: " + group);
		return edao.findByGroup(group);
	}

	@GET
	@Path("/event/searcht/{topic}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByTopic(@PathParam("topic") String topic) {
		System.out.println("findByTopic: " + topic);
		return edao.findByTopic(topic);
	}

	@GET
	@Path("/event/searchl/{location}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByLocation(@PathParam("location") String location) {
		System.out.println("findByLocation: " + location);
		return edao.findByLocation(location);
	}

	@GET
	@Path("/event/searche/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> eventFindByEmail(@PathParam("email") String email) {
		System.out.println("eventFindByEmail: " + email);
		return edao.eventFindByEmail(email);
	}

	@POST
	@Path("/event")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Event create(Event event) {
		System.out.println("create event");
		event.setDate(event.getDate());
		System.out.println("date is" + event.getDate());
		return edao.create(event);
	}

	@DELETE
	@Path("/event/{id}")
	public List<Event> remove(@PathParam("id") int id) {
		System.out.println("Deleted event on: " + id);
		edao.remove(id);
		return edao.findAll();
	}

	@PUT
	@Path("/event")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Event update(Event event) {
		event.setDate(event.getDate());
		System.out.println("Updating event: " + event.getDate());
		edao.update(event);
		return event;
	}
}