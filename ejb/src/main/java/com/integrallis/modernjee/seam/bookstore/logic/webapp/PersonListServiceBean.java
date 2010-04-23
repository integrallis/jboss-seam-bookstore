package com.integrallis.modernjee.seam.bookstore.logic.webapp;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;

import com.integrallis.modernjee.seam.bookstore.logic.framework.AbstractEntityListServiceBean;
import com.integrallis.modernjee.seam.bookstore.model.Gender;
import com.integrallis.modernjee.seam.bookstore.model.Person;

@Stateful
@Name(PersonListService.NAME)
@Scope(ScopeType.CONVERSATION)
public class PersonListServiceBean extends AbstractEntityListServiceBean<Person>
		implements PersonListService {

	@In(required = false)
	@Out(required = false)
	private Person person;

	private List<Person> resultList;

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getResultList() {
		if (resultList == null) {
			final Query query = entityManager
					.createQuery(PersonListService.QUERY_RESULT);
			resultList = query.getResultList();
		}
		return resultList;
	}

	@Override
	@Observer( { "com.integrallis.modernjee.seam.bookstore.persited.Person",
			"com.integrallis.modernjee.seam.bookstore.deleted.Person" })
	public void refresh() {
		resultList = null;
		log.info("refresh resultList");
	}

	@Override
	public void setSelectedEntity(Person person) {
		this.person = person;
	}

	@Factory
	public Gender[] getGender() {
		return Gender.values();
	}

	@Override
	public Person getSelectedEntity() {
		return person;
	}

	@Destroy
	@Remove
	public void destroy() {
		log.debug("destry component #0", this);
	}

}
