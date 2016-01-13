package com.smilesmile1973.controller.school;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.smilesmile1973.I18NUtils;
import com.smilesmile1973.controller.MainController;
import com.smilesmile1973.model.school.SchoolModel;
import com.smilesmile1973.view.school.SchoolFrame;

public class SchoolController {
	private SchoolFrame schoolFrame;
	private SchoolModel schoolModel;
	private MainController mainController;

	public SchoolController(MainController mainController) {
		initModel();
		this.mainController = mainController;
		schoolFrame = new SchoolFrame(schoolModel);
		schoolFrame.setVisible(true);
		initListeners();
	}

	private void initListeners() {
		schoolFrame.getMainPanel().addInsertButtonListener(new Listener() {
			public void handleEvent(Event event) {
				mainController.getWord().getActiveDocument().getActiveWindow().getSelection().setText("TTTT");
			}
		});

		schoolFrame.getMainPanel().addCancelButtonListener(new Listener() {

			public void handleEvent(Event event) {
				schoolFrame.dispose();
			}
		});

	}

	private void initModel() {
		schoolModel = new SchoolModel();
		schoolModel.setCourse(I18NUtils.INSTANCE.getString("school.course"));
		schoolModel.setFamilyName(I18NUtils.INSTANCE.getString("school.family.name"));
		schoolModel.setFirstName(I18NUtils.INSTANCE.getString("school.first.name"));
		schoolModel.setRoom(I18NUtils.INSTANCE.getString("school.room"));
		schoolModel.setShellTitle(I18NUtils.INSTANCE.getString("school.shell.title"));
		schoolModel.setCancel(I18NUtils.INSTANCE.getString("school.cancel"));
		schoolModel.setInsert(I18NUtils.INSTANCE.getString("school.insert"));
		schoolModel.setBrowse(I18NUtils.INSTANCE.getString("school.browse"));
	}
}
