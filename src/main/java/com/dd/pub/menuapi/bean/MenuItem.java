package com.dd.pub.menuapi.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem {

	@Id
	private int id;	
	private String itemName;
	private int price;
	
	public MenuItem(){}
	
	public MenuItem(int id, String itemName, int price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}