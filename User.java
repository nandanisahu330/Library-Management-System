package booklibrary;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return "User: " + name + " (ID: " + userId + ")";
    }

}
