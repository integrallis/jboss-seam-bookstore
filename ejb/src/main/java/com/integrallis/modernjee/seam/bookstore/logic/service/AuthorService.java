package com.integrallis.modernjee.seam.bookstore.logic.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.integrallis.modernjee.seam.bookstore.model.Author;

@Name("authorService")
@AutoCreate
public class AuthorService {

	@In
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Author> findAllAuthors() {
		return (List<Author>)entityManager.createQuery("Select a from Author a").getResultList();
	}
}
