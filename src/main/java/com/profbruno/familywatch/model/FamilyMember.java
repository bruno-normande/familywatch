package com.profbruno.familywatch.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class FamilyMember{

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String pwd;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Phone> phones = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
	
}
