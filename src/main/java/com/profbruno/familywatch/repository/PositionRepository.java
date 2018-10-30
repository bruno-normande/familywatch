package com.profbruno.familywatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profbruno.familywatch.model.Position;

@Repository
public interface PositionRepository  extends JpaRepository<Position, Long>{
	List<Position> findByPhoneId(Long phoneId);
}
