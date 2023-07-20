package com.candy.repository;

import com.candy.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {

}
