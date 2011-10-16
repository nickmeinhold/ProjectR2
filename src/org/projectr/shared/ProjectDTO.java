package org.projectr.shared;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ProjectDTO implements IsSerializable {
	
	String id;
	String name;
	String description;
	List<String> keywords;
	List<String> participantIds;
	Date commenced;
	List<String> taskIds;
	
	public ProjectDTO() {
		keywords = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(List<String> participantIds) {
		this.participantIds = participantIds;
	}

	public Date getCommenced() {
		return commenced;
	}

	public void setCommenced(Date commenced) {
		this.commenced = commenced;
	}

	public List<String> getTaskIds() {
		return taskIds;
	}

	public void setTaskIds(List<String> taskIds) {
		this.taskIds = taskIds;
	}

	public boolean addKeyword(String keyword) {
		return this.keywords.add(keyword);
	}
	
}
