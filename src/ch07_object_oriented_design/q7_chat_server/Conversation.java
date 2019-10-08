package ch07_object_oriented_design.q7_chat_server;

import java.util.ArrayList;

public class Conversation {
	private long id;
	private ArrayList<User> participants;
	private ArrayList<Message> messages;

	public void addParticipant(User u) {
		participants.add(u);
	}

	public void addMessage(Message m) {
		messages.add(m);
	}

	public ArrayList<User> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<User> participants) {
		this.participants = participants;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
