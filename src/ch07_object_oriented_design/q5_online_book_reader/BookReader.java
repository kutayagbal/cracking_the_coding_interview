package ch07_object_oriented_design.q5_online_book_reader;

public class BookReader {
	private Display display;
	private User currentUser;

	public BookReader() {
		display = new Display();
		display.displayLogin();
	}

	public void login(String username, String password) {
		currentUser = UserManager.login(username, password);
		if (currentUser == null) {
			display.displayRegister();
		} else {
			if (currentUser.getCurrentBook() != null) {
				display.displayUserInfo();
				display.displayPage(currentUser.getCurrentBook(), currentUser.getCurrentPage());
			}
		}
	}

	public void register(String username, String password) {
		currentUser = UserManager.register(username, password);
		if (currentUser.getCurrentBook() != null) {
			display.displayUserInfo();
			display.displayPage(currentUser.getCurrentBook(), currentUser.getCurrentPage());
		} else {
			display.displayUserInfo();
			display.displaySearch();
		}
	}

	public void search(String keyword) {
		display.displaySearchResults(BookStore.search(keyword));
	}

	public void selectBook(int id) {
		currentUser.setCurrentBook(BookStore.getBook(id));
		display.displayPage(currentUser.getCurrentBook(), currentUser.getCurrentPage());
	}

	public void displayNextPage() {
		currentUser.setCurrentPage(currentUser.getCurrentPage() + 1);
		display.displayPage(currentUser.getCurrentBook(), currentUser.getCurrentPage());
	}

	public void displayPrevPage() {
		currentUser.setCurrentPage(currentUser.getCurrentPage() - 1);
		display.displayPage(currentUser.getCurrentBook(), currentUser.getCurrentPage());
	}
}
