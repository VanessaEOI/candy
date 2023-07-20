package com.candy.repository;

import com.candy.entity.ItemCandyBox;
import com.candy.entity.ItemCandyBoxId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCandyBoxRepository extends JpaRepository<ItemCandyBox, ItemCandyBoxId> {
}