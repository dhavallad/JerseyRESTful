package jersey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private String id;
	private String name;
	private String phno;

	public Person() {

	}

	public Person(String id, String name, String phno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

}