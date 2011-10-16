package org.projectr.client;

import java.util.Arrays;
import java.util.List;

import org.projectr.client.events.ProjectSaveRequestEvent;
import org.projectr.client.events.ProjectSaveRequestEventHandler;
import org.projectr.shared.ProjectDTO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class ProjectCreationPresenter {

	ProjectServiceAsync projectService;
	ProjectCreationView view;
	
	public ProjectCreationPresenter(ProjectServiceAsync projectService1, ProjectCreationView view1) {
		
		this.projectService = projectService1;
		this.view = view1;
		
		projectService.retrieveKeywords(new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				Window.alert("Error retrieving keywords.");
			}

			public void onSuccess(List<String> result) {
				MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
				for(String s : result) {
					oracle.add(s);
				}
				view.setOracle(oracle);
			}
			
		});
		
		ProjectR.getEventBus().addHandler(ProjectSaveRequestEvent.TYPE, new ProjectSaveRequestEventHandler() {

			public void onProjectSaveRequest(ProjectSaveRequestEvent event) {
				
				ProjectDTO dto = new ProjectDTO();
				dto.setName(event.getName());
				dto.setDescription(event.getDescription());
				String[] splitted_string = event.getKeyWords().split(",");
				dto.setKeywords(Arrays.asList(splitted_string));
				
				projectService.createProject(dto, new AsyncCallback<ProjectDTO>() {

					public void onFailure(Throwable caught) {
						Window.alert("Error creating project, check internet connection.");
					}

					public void onSuccess(ProjectDTO result) {
						view.resetInterface();
					}
					
				});
				
			}
			
			
			
		});
		
		
		
	}
	
}
