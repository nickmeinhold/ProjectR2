package org.projectr.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SkillDTO implements IsSerializable {

	String id;
	String name;
	
	public SkillDTO() {
		
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
	
	
	
}
