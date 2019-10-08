package ch07_object_oriented_design.q5_online_book_reader;

public class User {
	private int id;
	private String username;
	private String password;
	private Book currentBook;
	private int currentPage;

	public User(int id, String name, String password) {
		this.id = id;
		this.username = name;
		this.password = password;
	}

	public Book getCurrentBook() {
		return currentBook;
	}

	public void setCurrentBook(Book currentBook) {
		this.currentBook = currentBook;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
