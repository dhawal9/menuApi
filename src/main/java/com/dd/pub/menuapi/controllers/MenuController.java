package com.dd.pub.menuapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dd.pub.menuapi.bean.MenuItem;
import com.dd.pub.menuapi.exceptions.ItemNotFoundException;
import com.dd.pub.menuapi.repository.MenuItemRepository;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuItemRepository repository;

	@GetMapping("/")
	public List<MenuItem> getMasterMenuList(){
		return repository.findAll();
	}

	@PostMapping("/addItem")
	public void addMenuItem(@RequestBody MenuItem menuItem){		
		repository.save(menuItem);
		ResponseEntity.ok();
	}

	@GetMapping("/getItem/{id}")
	public MenuItem getMenuItem(@PathVariable int id){
		return repository.findById(id).get();
	}

	@DeleteMapping("/deleteItem/{id}")
	public void deleteItem(@PathVariable int id) throws ItemNotFoundException{

		Optional<MenuItem> item = repository.findById(id);
		if(item.isPresent())
			repository.delete(item.get());
		else
			throw new ItemNotFoundException("Item Not Found with ID: "+ id);
	}

	@PutMapping("/updateItem")
	public void updateItemName(@RequestBody MenuItem menuItem) 
			throws ItemNotFoundException{
		
		Optional<MenuItem> item = repository.findById(menuItem.getId());
		if(item.isPresent()){
			item.get().setItemName(menuItem.getItemName());
			repository.save(item.get());
		}
		else
			throw new ItemNotFoundException();
	}
}