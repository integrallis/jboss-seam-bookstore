package com.integrallis.modernjee.seam.bookstore.logic.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;

import com.integrallis.modernjee.seam.bookstore.model.Author;
import com.integrallis.modernjee.seam.bookstore.model.Book;

@Stateless
@Name("searchService")
public class SearchServiceBean implements SearchService {
	
	@RequestParameter("titleToSearch")
	private String titleToSearch;
	
	@In
	EntityManager entityManager;
	
	@In
	AuthorService authorService;
	
	@Logger
	Log log;	
	
	@Out(required = false)
	List<Book> searchResults;
	
	@Out(required = false, scope = ScopeType.PAGE)
	List<Author> authors;
	
	@SuppressWarnings("unchecked")
	public List<Book> getResults() {
		System.out.println("~~~~~~ WTF!~~~~~");
		log.info("- Search -");
		searchResults = new ArrayList<Book>();
		if (titleToSearch != null && titleToSearch.trim().length() > 0) {
			searchResults = (List<Book>)entityManager.createQuery("Select b from Book b where b.title LIKE :title")
			.setParameter("title", titleToSearch).getResultList();
		}
		else {
			searchResults = (List<Book>)entityManager.createQuery("Select b from Book b").getResultList();
		}
		
		log.info("the results found : " + searchResults);
			
		return searchResults;
	}
	
	@Factory(value = "authors")
	public void lookUpAuthors() {	
		log.info("lookup the authors");
		authors = authorService.findAllAuthors();
	}
}