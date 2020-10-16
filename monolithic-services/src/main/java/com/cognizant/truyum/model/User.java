package com.cognizant.truyum.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="us_id")
	private int id;
	
	@Column(name="us_name")
	private String userName;
	
	@Column(name="us_first_name")
	private String firstName;
	
	@Column(name="us_last_name")
	private String lastName;
	
	@Column(name="us_password")
	private String password;
	
	
	 @ManyToMany( fetch = FetchType.EAGER)
	 @JoinTable(name = "cart",
	        joinColumns = @JoinColumn(name = "ct_us_id"), 
	        inverseJoinColumns = @JoinColumn(name = "ct_me_id"))
	 private Set<MenuItem> menuItemList;
	

	@ManyToMany( fetch = FetchType.EAGER)
	 @JoinTable(name = "user_role",
	        joinColumns = @JoinColumn(name = "ur_us_id"), 
	        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	 private Set<Role> roleList;

	
	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

}
