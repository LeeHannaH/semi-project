package eip.mvc.model.dto;

public class User {

	private String id;
	private String manager;
	
	public User() {}
	public User(String id, String manager) {
		this.id = id;
		this.manager = manager;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", manager=" + manager + "]";
	}
	
	
}
