package com.cognizant.authentication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="me_id")
	private int id;
	
	@Column(name="me_name")
	private String name;
	
	@Column(name="me_price",columnDefinition = "DECIMAL(8,2)")
	private float price;
	
	@Column(name="me_active")
	private boolean active;
	
	@Column(name="me_date_of_launch")
	private Date dateOfLaunch;
	
	@Column(name="me_category")
	private String category;
	
	@Column(name="me_free_delivery")
	private boolean freeDelivery;
	
	@Column(name="me_image")
	private String image;

	public MenuItem() {
	}

	public MenuItem(int id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.image = image;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
