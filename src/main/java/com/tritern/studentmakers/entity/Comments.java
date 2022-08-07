package com.tritern.studentmakers.entity;

public class Comments {
	private int ids;
	private String name;
	private String comment;

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comments [ids=" + ids + ", name=" + name + ", comment=" + comment + "]";
	}

}
