package org.projectr.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.projectr.shared.ProjectDTO;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class ProjectDAO {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    String id;
	@Persistent
	String name;
	@Persistent
	String description;
	@Persistent
	List<String> keywordIds;
	@Persistent
	List<String> participantIds;
	@Persistent
	Date commenced;
	@Persistent
	List<String> taskIds;
	
	private ProjectDAO() {
		
	}
	
	public ProjectDAO(ProjectDTO dto) {
		this();
		this.setId(dto.getId());
		this.setName(dto.getName());
		this.setDescription(dto.getDescription());
		// keywordIds are added separately 
		keywordIds = new ArrayList<String>();
		this.setParticipantIds(dto.getParticipantIds());
		this.setCommenced(dto.getCommenced());
		this.setTaskIds(dto.getTaskIds());
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getKeywordIds() {
		return keywordIds;
	}

	public void setKeywordIds(List<String> keywordIds) {
		this.keywordIds = keywordIds;
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
	
	public boolean addKeyWordId(String keywordId) {
		return this.keywordIds.add(keywordId);
	}
	
	ProjectDTO toDTO() {
		ProjectDTO dto = new ProjectDTO();
		dto.setId(this.getId());
		dto.setName(this.getName());
		dto.setDescription(this.getDescription());
		// keywords are added separately 
		dto.setParticipantIds(this.getParticipantIds());
		dto.setCommenced(this.getCommenced());
		dto.setTaskIds(this.getTaskIds());
		return dto;
	}
	
}
