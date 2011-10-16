package org.projectr.shared;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TaskDTO implements IsSerializable {

	Float percentComplete;
	List<String> subTaskIds;
	List<String> desiredSkillIds;
	Float estimatedHours;
	
}
