package com.integrallis.modernjee.seam.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

@Entity
@Name("book")
public class Book extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(nullable = false)
	private String title;		

	//required for jpa
	public Book(){
		super();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {

		StringBuilder values = new StringBuilder();
		values.append("title = " + title);

		return values.toString();
	}

}
