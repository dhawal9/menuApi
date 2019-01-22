package com.dd.pub.menuapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dd.pub.menuapi.bean.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{

	public MenuItem findByItemName(String itemName);
}