package com.somsakKaeworasan.marauders.repository;

import com.somsakKaeworasan.marauders.model.CRUD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepo extends JpaRepository<CRUD, Integer> {
}
