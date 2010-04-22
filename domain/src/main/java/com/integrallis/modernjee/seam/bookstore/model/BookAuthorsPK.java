package com.integrallis.modernjee.seam.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookAuthorsPK implements Serializable {
	private static final long serialVersionUID = 2592246855242723929L;

	@Column(name = "BOOK_ID", nullable = false)
	private Long bookId;
	
	@Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    public BookAuthorsPK() { }
    
    public BookAuthorsPK(Long bookId, String firstName, String lastName) { 
    	this.bookId = bookId;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    
}
