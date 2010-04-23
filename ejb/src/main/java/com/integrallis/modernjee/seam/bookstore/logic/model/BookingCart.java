package com.integrallis.modernjee.seam.bookstore.logic.model;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.ScopeType;

import com.integrallis.modernjee.seam.bookstore.model.Book;

@Name("bookingCart")
@Scope(ScopeType.SESSION)
public class BookingCart {
	List<Book> books = new ArrayList<Book>();
	String creditCard;
	String name;
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setCreditCard(String c) {
		creditCard = c;
	}
	
	public String getCreditCard() {
		return creditCard;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void reset() {
		name = "";
		creditCard = "";
		books = new ArrayList<Book>();
	}
	
	public String toString() {
		StringBuilder values = new StringBuilder();
		values.append("name = " + name);
		values.append("creditCard = " + creditCard);
		values.append("books = " + books);
		
		return values.toString();
	}
}