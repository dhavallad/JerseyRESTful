package jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class PersonResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	PersonService personService;

	public PersonResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		personService = new PersonService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Person getPerson() {
		Person person = personService.getPerson(id);
		return person;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Person getPersonAsHtml() {
		Person person = personService.getPerson(id);
		return person;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putPerson(JAXBElement<Person> personElement) {
		Person person = personElement.getValue();
		Response response;
		if (personService.getPersons().containsKey(person.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		personService.createPerson(person);
		return response;
	}

	@DELETE
	public void deletePerson() {
		personService.deletePerson(id);
	}

}