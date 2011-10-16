package org.projectr.client.events;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;

public class ProjectSaveRequestEvent extends GwtEvent<ProjectSaveRequestEventHandler> {

	public static Type<ProjectSaveRequestEventHandler> TYPE = new Type<ProjectSaveRequestEventHandler>();
	
	String name;
	String description;
	String keyWords;
	
	public ProjectSaveRequestEvent(String name, String description, String keyWords) {
		this.name = name;
		this.description = description;
		this.keyWords = keyWords;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getKeyWords() {
		return keyWords;
	}


	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProjectSaveRequestEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ProjectSaveRequestEventHandler handler) {
		handler.onProjectSaveRequest(this);
	}

	
	
}