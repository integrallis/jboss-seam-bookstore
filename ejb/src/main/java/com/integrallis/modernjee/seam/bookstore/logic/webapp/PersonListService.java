package com.integrallis.modernjee.seam.bookstore.logic.webapp;

import javax.ejb.Local;

import com.integrallis.modernjee.seam.bookstore.logic.framework.AbstractEntityListService;
import com.integrallis.modernjee.seam.bookstore.model.Gender;
import com.integrallis.modernjee.seam.bookstore.model.Person;

@Local
public interface PersonListService extends AbstractEntityListService<Person> {

	String NAME = "personListService";
	String QUERY_RESULT = "select person from Person person";

	Gender[] getGender();
}
