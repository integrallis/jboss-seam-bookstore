package com.integrallis.modernjee.seam.bookstore.logic.model;

import javax.ejb.Local;

import com.integrallis.modernjee.seam.bookstore.logic.framework.AbstractEntityService;
import com.integrallis.modernjee.seam.bookstore.model.Person;

@Local
public interface PersonService extends AbstractEntityService<Person>{
	String NAME = "personService";
}