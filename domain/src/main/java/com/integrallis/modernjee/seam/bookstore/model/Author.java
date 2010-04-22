package com.integrallis.modernjee.seam.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

@Entity
@Name("author")
@Table(name = "BookAuthors")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    protected BookAuthorsPK bookAuthorsPK;
	
	@NotNull
	@Column(nullable = false,insertable=false, updatable=false)
	private String firstName;		

	@NotNull
	@Column(nullable = false, insertable= false, updatable=false)
	private String lastName;
	
	//required for jpa
	public Author(){
		super();
	}	

	public BookAuthorsPK getBookAuthorsPK() {
		return bookAuthorsPK;
	}


	public void setBookAuthorsPK(BookAuthorsPK bookAuthorsPK) {
		this.bookAuthorsPK = bookAuthorsPK;
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


	public String toString() {
		return lastName + ", " + firstName;
	}

}
