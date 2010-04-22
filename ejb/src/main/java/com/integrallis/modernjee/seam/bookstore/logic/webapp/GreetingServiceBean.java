package com.integrallis.modernjee.seam.bookstore.logic.webapp;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;

@Stateless
@Name("helloAction")
public class GreetingServiceBean implements GreetingService {
	public String greet(String name) {
		return "Hello, " + name;
	}
}
