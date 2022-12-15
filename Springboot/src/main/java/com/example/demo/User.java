package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String address;
private float price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String name, String address, float price) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.price = price;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", address=" + address + ", price=" + price + "]";
}

}
