package com.ipo;
/*
 * "name":"TaskName",
		"manager":"ManagerName",
		"priority":"Low",
		"state":"To Do",
		"start":"Wed Dec 27 11:44:13 CET 2017",
		"end":"Wed Dec 27 11:44:13 CET 2018",
		"resources":[
			{
				"image_path": "/dev/null"
			}
		], 
		"anotation": "none"
 */
public class Task {
	private String name, manager, priority, state, start, end, resources;

	public Task(String name, String manager, String priority, String state, String start, String end,
			String resources) {
		super();
		this.name = name;
		this.manager = manager;
		this.priority = priority;
		this.state = state;
		this.start = start;
		this.end = end;
		this.resources = resources;
	}

	public String getEnd() {
		return end;
	}

	public String getManager() {
		return manager;
	}

	public String getName() {
		return name;
	}

	public String getPriority() {
		return priority;
	}

	public String getResources() {
		return resources;
	}

	public String getStart() {
		return start;
	}

	public String getState() {
		return state;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	

}
