package com.checkme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.MenuElement;

@Repository
public interface MenuElementRepository extends JpaRepository<MenuElement, Long> {

}
