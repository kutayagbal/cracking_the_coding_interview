package ch07_object_oriented_design.q7_chat_server;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private long id;
	private String email;
	private String password;
	private String displayName;
	private Status status;

	private HashMap<Long, User> friends;
	private HashMap<Long, Conversation> conversations;
	private ArrayList<FriendRequest> waitingRequests;

	private void sendMessage(String text, long convId) {
		Message m = new Message(this, text);
		Conversation conv = conversations.get(convId);

		for (User u : conv.getParticipants()) {
			u.conversations.get(convId).addMessage(m);
		}
	}

	private void startConversation(Long friendId) {
		User friend = friends.get(friendId);
		Conversation conv = new Conversation();

		ArrayList<User> participants = new ArrayList<>();
		participants.add(friend);
		participants.add(this);
		conv.setParticipants(participants);
		long convId = 0;// generateId();
		conv.setId(convId);// generate id

		for (User u : participants) {
			u.getConversations().put(convId, conv);
		}

		conversations.put(conv.getId(), conv);
	}

	public void sendFriendRequest(String email) {
		User user = UserManager.getUser(email);
		if (user != null) {
			FriendRequest req = new FriendRequest(this);
			user.getFriendRequest(req);
		}
	}
	
	public void respondFriendReq(long reqId, int response) {
		//find friend request
		//if response is 1= accepted, 0= denied
		if(response == 1) {
//			friends.put(key, value) put new friend to friends
		}
	}

	private void getFriendRequest(FriendRequest req) {
		waitingRequests.add(req);
	}

	public ArrayList<FriendRequest> getWaitingRequests() {
		return waitingRequests;
	}

	public void setWaitingRequests(ArrayList<FriendRequest> waitingRequests) {
		this.waitingRequests = waitingRequests;
	}

	public User(String email, String password, String displayName) {
		super();
		this.email = email;
		this.password = password;
		this.displayName = displayName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public HashMap<Long, Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(HashMap<Long, Conversation> conversations) {
		this.conversations = conversations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public HashMap<Long, User> getFriends() {
		return friends;
	}

	public void setFriends(HashMap<Long, User> friends) {
		this.friends = friends;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
