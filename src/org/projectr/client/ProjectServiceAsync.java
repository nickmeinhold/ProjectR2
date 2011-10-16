package org.projectr.client;

import java.util.List;

import org.projectr.shared.ProjectDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ProjectServiceAsync {

	void createProject(ProjectDTO dto, AsyncCallback<ProjectDTO> callback);

	void retrieveKeywords(AsyncCallback<List<String>> callback);
	
	
	
}
