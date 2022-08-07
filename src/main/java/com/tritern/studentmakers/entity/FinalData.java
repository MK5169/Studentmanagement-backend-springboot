package com.tritern.studentmakers.entity;

import java.util.List;

public class FinalData {

	private String Id;
	private String CollegeRank;
	private String address;
	private String schoolType;
	private List<String> aminities;
	private String Desc;
	private String Name;
	private List<Object> FeeStructure;
	private List<Object> Faculty;
	private List<Object> Review;
	private List<String> image;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCollegeRank() {
		return CollegeRank;
	}

	public void setCollegeRank(String collegeRank) {
		CollegeRank = collegeRank;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public List<String> getAminities() {
		return aminities;
	}

	public void setAminities(List<String> aminities) {
		this.aminities = aminities;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Object> getFeeStructure() {
		return FeeStructure;
	}

	public void setFeeStructure(List<Object> feeStructure) {
		FeeStructure = feeStructure;
	}

	public List<Object> getFaculty() {
		return Faculty;
	}

	public void setFaculty(List<Object> faculty) {
		Faculty = faculty;
	}

	public List<Object> getReview() {
		return Review;
	}

	public void setReview(List<Object> review) {
		Review = review;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "FinalData [Id=" + Id + ", CollegeRank=" + CollegeRank + ", address=" + address + ", schoolType="
				+ schoolType + ", aminities=" + aminities + ", Desc=" + Desc + ", Name=" + Name + ", FeeStructure="
				+ FeeStructure + ", Faculty=" + Faculty + ", Review=" + Review + ", image=" + image + "]";
	}

}
