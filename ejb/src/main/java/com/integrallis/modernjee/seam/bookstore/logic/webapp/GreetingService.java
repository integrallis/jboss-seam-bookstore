package com.integrallis.modernjee.seam.bookstore.logic.webapp;

import javax.ejb.Local;

import org.jboss.seam.annotations.remoting.WebRemote;

@Local
public interface GreetingService {
	@WebRemote
    public String greet(String name);
}
