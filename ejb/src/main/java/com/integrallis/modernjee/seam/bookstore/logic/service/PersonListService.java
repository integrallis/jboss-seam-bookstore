package com.integrallis.modernjee.seam.bookstore.logic.service;

import com.integrallis.modernjee.seam.bookstore.model.Person;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import java.util.Arrays;

@Name("personListEntityService")
public class PersonListService extends EntityQuery<Person> {
	int[] MAX_RESULTS_OPTION = { 10, 20, 30, 40, 50 };
	
	private static final String EJBQL = "select person from Person person";

	private static final String[] RESTRICTIONS = {
			"lower(firstname) like lower(concat(#{person.firstname},'%'))",
			"lower(lastname) like lower(concat(#{person.lastname},'%'))",};

	private Person person = new Person();

	public PersonListService() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
//		setMaxResults(25);
	}

	public Person getPerson() {
		return person;
	}	
	
	public int[] getMaxResultsOption() {
		return MAX_RESULTS_OPTION;
	}	
}