package com.zt;
/*
 * Achieving BY-DIRECTION Mapping between OneToMany to ManyToOne
 * */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String website;
	@Column(nullable = false, unique = true)
	private long phno; // phno should be not null and unique

	@OneToMany
	List<Branchs> branchs;

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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public List<Branchs> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branchs> branchs) {
		this.branchs = branchs;
	}

}
