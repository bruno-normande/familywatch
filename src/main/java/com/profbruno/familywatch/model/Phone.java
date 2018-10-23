package com.profbruno.familywatch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
}
