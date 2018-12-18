package com.profbruno.familywatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profbruno.familywatch.model.FamilyMember;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember,Long>{
	public Optional<FamilyMember> findByUsername(String username);

}
