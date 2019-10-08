package ch07_object_oriented_design.q5_online_book_reader;

public class Book {
	private String name;
	private String author;
	private int pageNumber;
	private String genre; 
	private int id;

	public Book(String name, String author, int pageNumber) {
		this.author = author;
		this.name = name;
		this.pageNumber = pageNumber;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getId() {
		return id;
	}

	public String getGenre() {
		return genre;
	}
	
	
}
