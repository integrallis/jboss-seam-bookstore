package com.integrallis.modernjee.seam.bookstore.logic.framework;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;

import com.integrallis.modernjee.seam.bookstore.model.AbstractEntity;

public abstract class AbstractEntityListServiceBean<T extends AbstractEntity>
		implements AbstractEntityListService<T> {

	@In
	protected EntityManager entityManager;
	
	@Logger
	protected Log log;
	
	private int maxResults = 20;

	public abstract List<T> getResultList();
	
	public abstract void setSelectedEntity(T entity);
	public abstract T getSelectedEntity();
	
	public abstract void refresh();

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int[] getMaxResultsOption() {
		return MAX_RESULTS_OPTION;
	}
}
