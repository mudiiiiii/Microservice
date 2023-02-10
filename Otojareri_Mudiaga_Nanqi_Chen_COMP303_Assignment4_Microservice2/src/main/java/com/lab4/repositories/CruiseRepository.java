package com.lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab4.model.Cruise;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Integer> {

}
