package com.integrallis.modernjee.seam.bookstore.logic.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.log.Log;

import com.integrallis.modernjee.seam.bookstore.model.Book;

@Stateless
@Name("searchService")
public class SearchServiceBean implements SearchService {
	
	@RequestParameter("titleToSearch")
	private String titleToSearch;
	
	@In
	EntityManager entityManager;
	
	@Logger
	Log log;
	
	@Out(required = false)
	List<Book> searchResults;
	
	@SuppressWarnings("unchecked")
	public List<Book> getResults() {
		log.info("- Search -");
		searchResults = new ArrayList<Book>();
		if (titleToSearch != null && titleToSearch.trim().length() > 0) {
			searchResults = (List<Book>)entityManager.createQuery("Select b from Book b where b.title LIKE :title")
			.setParameter("title", titleToSearch).getResultList();
		}
		
		log.info("the results found : " + searchResults);
			
		return searchResults;
	}
}