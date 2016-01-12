package com.smilesmile1973.controller.school;

import org.eclipse.swt.widgets.Display;

import com.smilesmile1973.I18NUtils;
import com.smilesmile1973.model.school.SchoolModel;
import com.smilesmile1973.view.school.SchoolFrame;

public class SchoolController {
	private SchoolFrame schoolFrame;
	private SchoolModel schoolModel;
	public SchoolController(){
		initModel();
		schoolFrame = new SchoolFrame(schoolModel);
		schoolFrame.setVisible(true);
	}
	
	private void initModel() {
		schoolModel = new SchoolModel();
		schoolModel.setCourse(I18NUtils.INSTANCE.getResourceBundle().getString("school.course"));
		schoolModel.setFamilyName(I18NUtils.INSTANCE.getResourceBundle().getString("school.family.name"));
		schoolModel.setFirstName(I18NUtils.INSTANCE.getResourceBundle().getString("school.first.name"));
		schoolModel.setRoom(I18NUtils.INSTANCE.getResourceBundle().getString("school.room"));
		schoolModel.setShellTitle(I18NUtils.INSTANCE.getResourceBundle().getString("school.shell.title"));
		schoolModel.setCancel(I18NUtils.INSTANCE.getResourceBundle().getString("school.cancel"));
		schoolModel.setInsert(I18NUtils.INSTANCE.getResourceBundle().getString("school.insert"));
		schoolModel.setBrowse(I18NUtils.INSTANCE.getResourceBundle().getString("school.browse"));
 	}
}
