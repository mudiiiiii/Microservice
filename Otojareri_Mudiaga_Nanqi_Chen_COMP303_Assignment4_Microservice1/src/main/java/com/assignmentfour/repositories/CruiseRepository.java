package com.assignmentfour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignmentfour.Cruise;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Integer> {

}
