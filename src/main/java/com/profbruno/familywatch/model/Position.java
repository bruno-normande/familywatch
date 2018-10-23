package com.profbruno.familywatch.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class Position {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDateTime timestamp;

}
