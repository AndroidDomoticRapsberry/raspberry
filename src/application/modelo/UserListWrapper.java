package application.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
public class UserListWrapper {

	private List<User> users;
	
	@XmlElement(name = "user")
	public List<User> getUser(){
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
