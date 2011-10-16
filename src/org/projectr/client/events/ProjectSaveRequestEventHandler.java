package org.projectr.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface ProjectSaveRequestEventHandler extends EventHandler {

	void onProjectSaveRequest(ProjectSaveRequestEvent event);
	
}
