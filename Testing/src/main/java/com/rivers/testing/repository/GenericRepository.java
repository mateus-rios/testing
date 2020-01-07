package com.rivers.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rivers.testing.entity.Generic;


@Repository
public interface GenericRepository extends JpaRepository<Generic, Long> {

	public Generic findByName(String name);
}
