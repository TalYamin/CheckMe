package com.checkme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.RestTable;

@Repository
public interface RestTabelRepository extends JpaRepository<RestTable, Long>{

}
