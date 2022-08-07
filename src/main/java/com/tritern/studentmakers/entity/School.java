package com.tritern.studentmakers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School {
	@Id
	@Column(name = "id")
	private long id;

	@Column(columnDefinition = "text")
	private String details;

	@Column(columnDefinition = "text")
	private String address;

	@Column(columnDefinition = "text")
	private String Description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", details=" + details + ", address=" + address + ", Description=" + Description
				+ "]";
	}

}
