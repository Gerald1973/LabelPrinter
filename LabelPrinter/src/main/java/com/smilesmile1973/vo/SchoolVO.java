package com.smilesmile1973.vo;

public class SchoolVO {
	private String name;
	private String firstName;
	private String course;
	private String room;
	private String pathAndFileName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	

	public String getString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(firstName).append("\n").append(name).append("\n").append(course).append("\n").append(room);
		return stringBuffer.toString();
	}

	public String getPathAndFileName() {
		return pathAndFileName;
	}

	public void setPathAndFileName(String pathAndFileName) {
		this.pathAndFileName = pathAndFileName;
	}
}
