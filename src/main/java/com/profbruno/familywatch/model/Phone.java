package com.profbruno.familywatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String number;
	
	@OneToMany(
			mappedBy="phone",
			cascade=CascadeType.ALL,
			orphanRemoval=true
			)
	private List<Position> positions = new ArrayList<>();

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
