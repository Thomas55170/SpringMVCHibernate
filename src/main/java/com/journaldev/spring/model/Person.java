package com.journaldev.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String country;

	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private ArrayList<StrongBox> strongBoxList = new ArrayList<StrongBox>();

	public int getId() {
		return id;
	}

	public void setId(int id)	 {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*public ArrayList<StrongBox> getStrongBoxList() {
		return strongBoxList;
	}*/
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
