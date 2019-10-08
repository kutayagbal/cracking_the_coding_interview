package ch07_object_oriented_design.q7_chat_server;

public class Message {
	private User author;
	private String text;

	public Message(User author, String text) {
		super();
		this.author = author;
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
