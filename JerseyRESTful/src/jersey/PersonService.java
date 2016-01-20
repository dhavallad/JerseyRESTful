package jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonService {

	PersonDao personDao;

	public PersonService() {
		personDao = PersonDao.instance;
	}

	public void createPerson(Person person) {
		personDao.getPersons().put(person.getId(), person);
	}

	public Person getPerson(String id) {
		return personDao.getPersons().get(id);
	}

	public Map<String, Person> getPersons() {
		return personDao.getPersons();
	}

	public List<Person> getPersonAsList() {
		List<Person> personList = new ArrayList<Person>();
		personList.addAll(personDao.getPersons().values());
		return personList;
	}

	public int getPersonsCount() {
		return personDao.getPersons().size();
	}

	public void deletePerson(String id) {
		personDao.getPersons().remove(id);
	}

}