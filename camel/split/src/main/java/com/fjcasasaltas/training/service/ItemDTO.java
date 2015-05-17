package com.fjcasasaltas.training.service;

import java.io.Serializable;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = -757496087135798980L;

	private Long id;
	private String description;

	public ItemDTO() {
		this(null, null);
	}

	public ItemDTO(final Long id, final String description) {
		this.setId(id);
		this.setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
