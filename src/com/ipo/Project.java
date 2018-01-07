package com.ipo;

public class Project {
	private String name, image_path, created_at, manager, description;

	public Project(String name, String image_path, String created_at, String manager, String description) {
		super();
		this.name = name;
		this.image_path = image_path;
		this.created_at = created_at;
		this.manager = manager;
		this.description = description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getDescription() {
		return description;
	}

	public String getImage_path() {
		return image_path;
	}

	public String getManager() {
		return manager;
	}

	public String getName() {
		return name;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
