package com.ipo;

public class User {
	private String last_access, user, name, image_path, rol;

	public User(String last_access, String user, String name, String image_path, String rol) {
		super();
		this.last_access = last_access;
		this.user = user;
		this.name = name;
		this.image_path = image_path;
		this.rol = rol;
	}

	public String getImage_path() {
		return image_path;
	}

	public String getLast_access() {
		return last_access;
	}

	public String getName() {
		return name;
	}

	public String getRol() {
		return rol;
	}

	public String getUser() {
		return user;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public void setLast_access(String last_access) {
		this.last_access = last_access;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
