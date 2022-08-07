package com.tritern.studentmakers.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "image")
public class Image {

	@Id
	private String id;

	@Field(name = "schoolOrcollegeId")
	private String name;

	@Field(name = "imagename")
	private String imagename;

	@Field(name = "image")
	private List<String> image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", imagename=" + imagename + ", image=" + image + "]";
	}

}
