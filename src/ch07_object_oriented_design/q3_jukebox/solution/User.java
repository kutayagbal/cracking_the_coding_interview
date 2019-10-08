package ch07_object_oriented_design.q3_jukebox.solution;

public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	private long ID;

	public User(String name, long iD) {
		this.ID = iD;
		this.name = name;
	}

	public User getUser() {
		return this;
	}

	public static User addUser(String name, long iD) {
		// add user to databases
		return null;
	}
}