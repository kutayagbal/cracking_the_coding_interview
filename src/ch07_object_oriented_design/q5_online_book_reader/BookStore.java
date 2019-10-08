package ch07_object_oriented_design.q5_online_book_reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BookStore {
	private static Map<Integer, Book> books;

	public BookStore() {
		books = new HashMap<>();
	}

	public static ArrayList<Book> search(String keyword) {
		ArrayList<Book> resultList = new ArrayList<>();
		for (Entry<Integer, Book> e : books.entrySet()) {
			Book b = e.getValue();
			if (b.getName().contains(keyword) || b.getAuthor().contains(keyword) || b.getGenre().contains(keyword)) {
				resultList.add(b);
			}
		}

		return resultList;
	}

	public static void addBook(Book b) {
		// TODO: check if already exists.
		books.put(generateId(), b);
	}

	private static Integer generateId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void removeBook(int id) {
		books.remove(id);
	}

	public static Book getBook(int id) {
		return books.get(id);
	}
}
