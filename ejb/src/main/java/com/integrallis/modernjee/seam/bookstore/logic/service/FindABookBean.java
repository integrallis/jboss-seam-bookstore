package com.integrallis.modernjee.seam.bookstore.logic.service;

import javax.ejb.Stateless;

@Stateless
public class FindABookBean implements FindABook {
	
	public String randomDisplay() {
		return "My Random Book";
	}
}
