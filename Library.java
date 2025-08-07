package booklibrary;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	 private Map<String, Book> books;
	    private Map<String, User> users;

	    public Library() {
	        this.books = new HashMap<>();
	        this.users = new HashMap<>();
	    }

	    public void addBook(Book book) {
	        books.put(book.getIsbn(), book);
	        System.out.println("Added " + book);
	    }

	    public void registerUser(User user) {
	        users.put(user.getUserId(), user);
	        System.out.println("Registered " + user);
	    }

	    public String issueBook(String userId, String isbn) {
	        if (!users.containsKey(userId)) {
	            return "User not found";
	        }
	        if (!books.containsKey(isbn)) {
	            return "Book not found";
	        }

	        User user = users.get(userId);
	        Book book = books.get(isbn);

	        if (!book.isAvailable()) {
	            return book.toString() + " is already borrowed";
	        }

	        book.setAvailable(false);
	        book.setCurrentBorrower(user);
	        book.setDueDate(LocalDate.now().plusDays(14)); // 2 weeks loan
	        user.getBorrowedBooks().add(book);

	        return book.toString() + " issued to " + user + ". Due: " + book.getDueDate();
	    }

	    public String returnBook(String isbn) {
	        if (!books.containsKey(isbn)) {
	            return "Book not found";
	        }

	        Book book = books.get(isbn);
	        if (book.isAvailable()) {
	            return book.toString() + " is not borrowed";
	        }

	        User user = book.getCurrentBorrower();
	        user.getBorrowedBooks().remove(book);
	        book.setAvailable(true);
	        book.setCurrentBorrower(null);
	        book.setDueDate(null);

	        return book.toString() + " returned successfully";
	    }

	    public List<Map.Entry<Book, User>> checkOverdue() {
	        List<Map.Entry<Book, User>> overdue = new ArrayList<>();
	        for (Book book : books.values()) {
	            if (!book.isAvailable() && book.getDueDate() != null && book.getDueDate().isBefore(LocalDate.now())) {
	                overdue.add(new AbstractMap.SimpleEntry<>(book, book.getCurrentBorrower()));
	            }
	        }
	        return overdue;
	    }

	    public static void main(String[] args) {
	        // Create library
	        Library library = new Library();

	        // Create books
	        Book book1 = new Book("1984", "George Orwell", "123456789");
	        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");

	        // Create user
	        User user1 = new User("U001", "Alice Smith");

	        // Add books and user to library
	        library.addBook(book1);
	        library.addBook(book2);
	        library.registerUser(user1);

	        // Test issue and return
	        System.out.println(library.issueBook("U001", "123456789"));
	        System.out.println(library.issueBook("U001", "987654321"));
	        System.out.println(library.returnBook("123456789"));

	        // Check overdue books
	        List<Map.Entry<Book, User>> overdueBooks = library.checkOverdue();
	        for (Map.Entry<Book, User> entry : overdueBooks) {
	            System.out.println("Overdue: " + entry.getKey() + " borrowed by " + entry.getValue());
	        }
	    }
	
}
