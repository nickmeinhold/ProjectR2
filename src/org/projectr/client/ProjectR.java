package org.projectr.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectR implements EntryPoint {
	
	private final ProjectServiceAsync projectService = GWT.create(ProjectService.class);
	
	private static final EventBus eventBus = new SimpleEventBus();
	
	Panel mainPnl = new VerticalPanel();
	ProjectCreationView projectCreationView = new ProjectCreationView();
	ProjectCreationPresenter projectCreationPresenter = new ProjectCreationPresenter(projectService, projectCreationView);

	public void onModuleLoad() {
		
		RootPanel.get("appgoeshere").add(mainPnl);
		
		mainPnl.add(projectCreationView);
		
	}
	
	public static EventBus getEventBus(){
		return eventBus;
	}
}
