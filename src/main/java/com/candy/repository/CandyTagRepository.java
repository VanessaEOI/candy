package com.candy.repository;

import com.candy.entity.CandyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandyTagRepository extends JpaRepository<CandyTag, Integer> {


}