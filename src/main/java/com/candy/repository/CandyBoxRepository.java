package com.candy.repository;

import com.candy.entity.CandyBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandyBoxRepository extends JpaRepository<CandyBox, Integer> {


}
