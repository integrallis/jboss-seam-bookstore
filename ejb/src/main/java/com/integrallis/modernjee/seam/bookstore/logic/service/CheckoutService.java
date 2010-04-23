package com.integrallis.modernjee.seam.bookstore.logic.service;

import com.integrallis.modernjee.seam.bookstore.model.Book;

public interface CheckoutService {
	
	void checkout();
	void clearCart();
	void purchase();
	void addToCart();
	void addToCart(Long b);	
}