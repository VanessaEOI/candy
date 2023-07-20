package com.candy.repository;

import com.candy.entity.Candytag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandytagRepository extends JpaRepository<Candytag, Integer> {


}