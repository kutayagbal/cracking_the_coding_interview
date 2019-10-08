package ch07_object_oriented_design.q5_online_book_reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UserManager {
	private static Map<Integer, User> users;

	public UserManager() {
		users = new HashMap<Integer, User>();
	}

	public void addUser(User u) {
		if (!users.containsKey(u.getId())) {
			users.put(u.getId(), u);
		}
	}

	public User getUser(int id) {
		return users.get(id);
	}

	public static User login(String username, String password) {
		for (Entry<Integer, User> e : users.entrySet()) {
			User u = e.getValue();
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}

		return null;
	}

	public static User register(String username, String password) {
		int id = generateId();
		User user = new User(id, username, password);
		users.put(id, user);
		return user;
	}

	private static int generateId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
