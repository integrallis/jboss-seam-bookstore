package com.integrallis.modernjee.seam.bookstore.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Class implementing the basic properties of all entities.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	protected final Long id = null;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Version
	private Date lastChange;
	
	public Long getId() {
		return id;
	}
	
	public final Date getLastChange() {
		return lastChange;
	}
}
