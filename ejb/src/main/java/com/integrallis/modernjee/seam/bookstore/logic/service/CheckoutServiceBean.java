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

import com.integrallis.modernjee.seam.bookstore.logic.model.BookingCart;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import javax.persistence.EntityManager;
import org.jboss.seam.annotations.web.RequestParameter;

@Stateless
@Name("checkoutService")
public class CheckoutServiceBean implements CheckoutService {
	
	@In(create = true)
	@Out(scope = ScopeType.SESSION)
	BookingCart bookingCart;
	
	@RequestParameter("bookId")
	Long bookId;
	
	@In(required = false)
	Book book;
	
	@Logger
	Log log;
	
	@In
	EntityManager entityManager;
	
	public void checkout() {
		System.out.println("CHECKOUT!!! > " +bookingCart);
	}
	
	public void clearCart() {
		System.out.println("clearCart!!! > " + bookingCart);
		bookingCart.reset();
		System.out.println("clearCart!!! > " + bookingCart);
	}
	
	public void purchase() {
		System.out.println("purchase!!! > " + bookingCart);
	}
	
	
	public void addToCart(Long id) {
		System.out.println("The book id pparam - " + bookId);
		System.out.println("add to cart! 3");
		log.info("ADD TO CART!!!!!! 3");
		Book book = entityManager.find(Book.class, id);
		System.out.println(id);
		System.out.println(book);
		bookingCart.addBook(book);
	}
	
	public void addToCart() {
		System.out.println("The book id pparam - " + bookId);
		System.out.println("add to cart!");		
		log.info("ADD TO CART!!!!!!");
		Book book = entityManager.find(Book.class, bookId);
		if (book != null) {
			System.out.println("not null - " + book.getTitle());
		}
		else {
			System.out.println("book is null");
		}
		
		bookingCart.addBook(book);
	}
}