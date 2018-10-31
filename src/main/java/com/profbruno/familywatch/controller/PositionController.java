package com.profbruno.familywatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profbruno.familywatch.exception.ResourceNotFoundException;
import com.profbruno.familywatch.model.Position;
import com.profbruno.familywatch.repository.PositionRepository;

@RestController
public class PositionController {
	@Autowired
	private PositionRepository positionRepository;
	
	@GetMapping("/position")
	public Page<Position> getpositions(Pageable pageable){
		return positionRepository.findAll(pageable);
	}
	
	@PostMapping("/position")
	public Position createposition(@Valid @RequestBody Position position) {
		return positionRepository.save(position);
	}
	
	@PutMapping("/position/{positionId}")
	public Position updateposition(@PathVariable Long positionId,
								@Valid @RequestBody Position positionRequest) {
		return positionRepository.findById(positionId)
				.map(position -> {
					position.setPhone(positionRequest.getPhone());
					position.setCoordinate(positionRequest.getCoordinate());
					return positionRepository.save(position);
				}).orElseThrow(() -> new ResourceNotFoundException("position not found:" + positionId));
	}
	
	@DeleteMapping("/position/{positionId}")
	public ResponseEntity<?> deleteposition(@PathVariable Long positionId) {
		return positionRepository.findById(positionId)
				.map(position -> {
					positionRepository.delete(position);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("position not found:" + positionId));
	}
}
