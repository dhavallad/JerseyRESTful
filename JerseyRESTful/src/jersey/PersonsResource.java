package jersey;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/persons")
public class PersonsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	PersonService personService;

	public PersonsResource() {
		personService = new PersonService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Person> getAnimals() {
		return personService.getPersonAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Person> getAnimalsAsHtml() {
		return personService.getPersonAsList();
	}

	// URI: /rest/persons/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(personService.getPersonsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createAnimal(@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("phno") String phno,
			@Context HttpServletResponse servletResponse) throws IOException {
		Person person = new Person(id, name, phno);
		personService.createPerson(person);
		servletResponse.sendRedirect("./persons/");
	}

	@Path("{person}")
	public PersonResource getAnimal(@PathParam("person") String id) {
		return new PersonResource(uriInfo, request, id);
	}

}