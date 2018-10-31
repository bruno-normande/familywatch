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

import com.profbruno.familywatch.repository.PhoneRepository;
import com.profbruno.familywatch.exception.ResourceNotFoundException;
import com.profbruno.familywatch.model.Phone;

@RestController
public class PhoneController {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@GetMapping("/phone")
	public Page<Phone> getPhones(Pageable pageable){
		return phoneRepository.findAll(pageable);
	}
	
	@PostMapping("/phone")
	public Phone createPhone(@Valid @RequestBody Phone phone) {
		return phoneRepository.save(phone);
	}
	
	@PutMapping("/phone/{phoneId}")
	public Phone updatePhone(@PathVariable Long phoneId,
								@Valid @RequestBody Phone phoneRequest) {
		return phoneRepository.findById(phoneId)
				.map(phone -> {
					phone.setNumber(phoneRequest.getNumber());
					return phoneRepository.save(phone);
				}).orElseThrow(() -> new ResourceNotFoundException("Phone not found:" + phoneId));
	}
	
	@DeleteMapping("/phone/{phoneId}")
	public ResponseEntity<?> deletePhone(@PathVariable Long phoneId) {
		return phoneRepository.findById(phoneId)
				.map(phone -> {
					phoneRepository.delete(phone);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Phone not found:" + phoneId));
	}

}
