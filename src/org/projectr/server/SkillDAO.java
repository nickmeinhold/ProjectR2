package org.projectr.server;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.projectr.shared.SkillDTO;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class SkillDAO {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    String id;
	@Persistent
	String name;
	
	private SkillDAO() {
		
	}
	
	public SkillDAO(SkillDTO dto) {
		this();
		
		this.setId(dto.getId());
		this.setName(dto.getName());
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
	
	SkillDTO toDTO() {
		
		SkillDTO dto = new SkillDTO();
		dto.setId(this.getId());
		dto.setName(this.getName());
		
		return dto;
	}
	
}
