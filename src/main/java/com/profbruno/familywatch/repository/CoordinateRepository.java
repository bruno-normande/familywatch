package com.profbruno.familywatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profbruno.familywatch.model.Coordinate;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
