package org.projectr.client;

import java.util.List;

import org.projectr.shared.ProjectDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("project")
public interface ProjectService extends RemoteService {
	
	ProjectDTO createProject(ProjectDTO dto);
	List<String> retrieveKeywords();
	
}
