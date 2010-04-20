package com.integrallis.modernjee.seam.bookstore.logic.model;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;

import com.integrallis.modernjee.seam.bookstore.logic.framework.AbstractEntityServiceBean;
import com.integrallis.modernjee.seam.bookstore.model.Person;

@Stateless
@Name(PersonService.NAME)
public class PersonServiceBean extends AbstractEntityServiceBean<Person>
		implements PersonService {
}
