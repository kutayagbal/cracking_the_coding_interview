package ch07_object_oriented_design.q7_chat_server;

import java.util.HashMap;

public class UserManager {
	private static HashMap<Long, User> users;

	public static void register(User u) {
		users.put(generateId(), u);
	}

	public static User login(String email, String password) {
		// find and return user
		return null;
	}

	public static Long generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void deleteUser(Long id) {
		users.remove(id);
	}

	public static User getUser(String email) {
		// find and return user
		return null;
	}

}
