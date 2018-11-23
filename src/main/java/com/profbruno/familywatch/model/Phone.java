package com.profbruno.familywatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@ManyToOne
	private FamilyMember owner;

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

	@JsonIgnore
	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions.clear();
		this.positions.addAll(positions);
	}

	@JsonIgnore
	public FamilyMember getOwner() {
		return owner;
	}

	public void setOwner(FamilyMember owner) {
		this.owner = owner;
	}

	
}
