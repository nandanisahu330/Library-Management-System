package booklibrary;

import java.time.LocalDate;

public class Book {
	 private String title;
	    private String author;
	    private String isbn;
	    private boolean isAvailable;
	    private User currentBorrower;
	    private LocalDate dueDate;

	    public Book(String title, String author, String isbn) {
	        this.title = title;
	        this.author = author;
	        this.isbn = isbn;
	        this.isAvailable = true;
	        this.currentBorrower = null;
	        this.dueDate = null;
	    }

	    public String getIsbn() {
	        return isbn;
	    }

	    public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void setAvailable(boolean available) {
	        isAvailable = available;
	    }

	    public User getCurrentBorrower() {
	        return currentBorrower;
	    }

	    public void setCurrentBorrower(User borrower) {
	        this.currentBorrower = borrower;
	    }

	    public LocalDate getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(LocalDate dueDate) {
	        this.dueDate = dueDate;
	    }

	    @Override
	    public String toString() {
	        return title + " by " + author + " (ISBN: " + isbn + ")";
	    }
	}
