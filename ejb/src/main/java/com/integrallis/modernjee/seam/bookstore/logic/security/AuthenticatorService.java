package com.integrallis.modernjee.seam.bookstore.logic.security;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.integrallis.modernjee.seam.bookstore.model.Person;

@Name("authenticator")
public class AuthenticatorService {

	@Logger
	protected Log log;
	
	@In
	EntityManager entityManager;

	public boolean authenticate() {		
		log.info("authenticate");

		boolean auth = false;
		try {
			Person p = (Person) entityManager.createQuery("Select p from Person p where p.firstname = :user and p.lastname = :pass")
				.setParameter("user", Identity.instance().getCredentials().getUsername())
				.setParameter("pass", Identity.instance().getCredentials().getPassword())
				.getSingleResult();
			
			if (p.getFirstname().equals("joseph")) {
				Identity.instance().addRole("admin");
			}
			else if (p.getFirstname().equals("brian")) {
				Identity.instance().addRole("nonadmin");
			}
			else {
				Identity.instance().addRole("user");
			}
			auth = true;
			
		} catch(Throwable t) {
			log.warn("invalid user");
		}
		return auth;
	}
	
	// Identity
	// either inject like @In Identity
	// or Identity.instance()
	// getUserName() getPassword()
	// addRole(---)
}
