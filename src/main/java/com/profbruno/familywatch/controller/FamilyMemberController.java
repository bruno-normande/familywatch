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
import com.profbruno.familywatch.model.FamilyMember;
import com.profbruno.familywatch.repository.FamilyMemberRepository;

@RestController
public class FamilyMemberController {

	@Autowired
	private FamilyMemberRepository familyMemberRepository;
	
	@GetMapping("/familymember")
	public Page<FamilyMember> getFamilyMembers(Pageable pageable){
		return familyMemberRepository.findAll(pageable);
	}
	
	@PostMapping("/familymember")
	public FamilyMember createFamilyMember(@Valid @RequestBody FamilyMember familyMember) {
		return familyMemberRepository.save(familyMember);
	}
	
	@PutMapping("/familymember/{familyMemberId}")
	public FamilyMember updateFamilyMember(@PathVariable Long familyMemberId,
            								@Valid @RequestBody FamilyMember familyMemberRequest) {
		return familyMemberRepository.findById(familyMemberId)
				.map(familyMember -> {
					familyMember.setName(familyMemberRequest.getName());
					familyMember.setPwd(familyMemberRequest.getPwd());
					familyMember.setPhones(familyMemberRequest.getPhones());
					familyMember.setEmail(familyMemberRequest.getEmail());
					return familyMemberRepository.save(familyMember);
		}).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found: " + familyMemberId));
	}
	
	@DeleteMapping("/familymember/{familyMemberId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long familyMemberId){
		return familyMemberRepository.findById(familyMemberId)
				.map(familyMember -> {
					familyMemberRepository.delete(familyMember);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("FamilyMember not found: " + familyMemberId));
	}
}
