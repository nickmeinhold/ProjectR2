package org.projectr.client;

import org.projectr.client.events.ProjectSaveRequestEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;

public class ProjectCreationView extends Composite {

	private static ProjectCreationItfUiBinder uiBinder = GWT.create(ProjectCreationItfUiBinder.class);
	@UiField HorizontalPanel suggestBoxPnl;
	@UiField Button saveBtn;
	@UiField TextBox nameTB;
	@UiField TextArea descriptionTA;
	
	SuggestBox sb;

	interface ProjectCreationItfUiBinder extends
			UiBinder<Widget, ProjectCreationView> {
	}

	public ProjectCreationView() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public void setOracle(MultiWordSuggestOracle oracle) {
		sb = new SuggestBox(oracle);
		suggestBoxPnl.add(sb);
	}
	
	public void resetInterface() {
		saveBtn.setEnabled(true);
		sb.setValue("");
		nameTB.setValue("");
		descriptionTA.setValue("");
	}

	@UiHandler("saveBtn")
	void onSaveBtnClick(ClickEvent event) {
		saveBtn.setEnabled(false);
		ProjectR.getEventBus().fireEvent(new ProjectSaveRequestEvent(nameTB.getValue(), descriptionTA.getValue(), sb.getValue()));
	}
}
