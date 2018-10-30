package com.profbruno.familywatch.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Position {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDateTime timestamp;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Phone phone;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Coordinate coordinate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	

}
