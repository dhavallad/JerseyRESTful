package jersey;

import java.util.HashMap;
import java.util.Map;

public enum PersonDao {
	instance;

	private Map<String, Person> persons = new HashMap<String, Person>();

	private PersonDao() {

		//pumping-in some default data
		Person person = new Person("1", "Dhaval", "123123123");
		persons.put("1", person);
		person = new Person("2", "Lad", "234234234");
		persons.put("2", person);

	}

	public Map<String, Person> getPersons() {
		return persons;
	}

}