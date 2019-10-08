package ch07_object_oriented_design.q7_chat_server;

public class FriendRequest {
	private long id;
	private User sender;

	public FriendRequest(User sender) {
		super();
		this.sender = sender;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
