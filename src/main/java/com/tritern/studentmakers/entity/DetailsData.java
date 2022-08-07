package com.tritern.studentmakers.entity;

import java.util.List;

public class DetailsData {

	private String Id;
	private String CollegeRank;
	private String Address;
	private String SchoolType;
	private List<String> Aminities;
	private String Desc;
	private String Name;
	private List<Object> FeeStructure;
	private List<Object> Faculty;
	private List<Object> Review;

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
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getSchoolType() {
		return SchoolType;
	}

	public void setSchoolType(String SchoolType) {
		this.SchoolType = SchoolType;
	}

	public List<String> getAminities() {
		return Aminities;
	}

	public void setAminities(List<String> Aminities) {
		this.Aminities = Aminities;
	}

	public String getDescription() {
		return Desc;
	}

	public void setDescription(String Desc) {
		this.Desc = Desc;
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

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public List<Object> getReview() {
		return Review;
	}

	public void setReview(List<Object> review) {
		Review = review;
	}

	@Override
	public String toString() {
		return "DetailsData [Id=" + Id + ", CollegeRank=" + CollegeRank + ", Address=" + Address + ", SchoolType="
				+ SchoolType + ", Aminities=" + Aminities + ", Desc=" + Desc + ", Name=" + Name + ", FeeStructure="
				+ FeeStructure + ", Faculty=" + Faculty + ", Review=" + Review + "]";
	}

}
