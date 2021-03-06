package com.integrallis.modernjee.seam.bookstore.logic.service;

import java.util.List;

import com.integrallis.modernjee.seam.bookstore.model.Author;
import com.integrallis.modernjee.seam.bookstore.model.Book;

public interface SearchService {
	List<Book> getResults();
	void lookUpAuthors();
}