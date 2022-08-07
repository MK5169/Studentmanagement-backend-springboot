package com.tritern.studentmakers.entity;

import java.util.List;

import com.poiji.annotation.ExcelCellName;

public class ExcelData {

	@ExcelCellName("ID")
	private String id;
	@ExcelCellName("Type")
	private String type;
	@ExcelCellName("Section")
	private String section;
	@ExcelCellName("Name")
	private String name;
	@ExcelCellName("Address")
	private String Address;
	@ExcelCellName("Amenities")
	private List<String> Aminities;
	@ExcelCellName("Description")
	private String Desc;
	@ExcelCellName("Course")
	private String course;
	@ExcelCellName("Fees")
	private String fees;
	@ExcelCellName("Faculty Name")
	private String facultyName;
	@ExcelCellName("Faculty Description")
	private String facultyDescription;
	@ExcelCellName("Review")
	private List<String> review;
	@ExcelCellName("Rating")
	private List<String> rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<String> getAminities() {
		return Aminities;
	}

	public void setAminities(List<String> aminities) {
		Aminities = aminities;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyDescription() {
		return facultyDescription;
	}

	public void setFacultyDescription(String facultyDescription) {
		this.facultyDescription = facultyDescription;
	}

	public List<String> getReview() {
		return review;
	}

	public void setReview(List<String> review) {
		this.review = review;
	}

	public List<String> getRating() {
		return rating;
	}

	public void setRating(List<String> rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ExcelData [id=" + id + ", type=" + type + ", section=" + section + ", name=" + name + ", Address="
				+ Address + ", Aminities=" + Aminities + ", Desc=" + Desc + ", course=" + course + ", fees=" + fees
				+ ", facultyName=" + facultyName + ", facultyDescription=" + facultyDescription + ", review=" + review
				+ ", rating=" + rating + "]";
	}

}
