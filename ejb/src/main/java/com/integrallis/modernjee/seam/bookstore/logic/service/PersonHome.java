package com.integrallis.modernjee.seam.bookstore.logic.service;

import com.integrallis.modernjee.seam.bookstore.model.Person;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

@Name("personHome")
public class PersonHome extends EntityHome<Person> {
	
	@Override
	protected Person createInstance() {
		Person person = new Person();
		return person;
	}	
}