package com.smilesmile1973.controller;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;
import com.smilesmile1973.controller.school.SchoolController;
import com.smilesmile1973.ms.word.Word;
import com.smilesmile1973.view.MainShell;

public class MainController {
	private Variant variantApplication;
	private MainShell mainShell;

	public MainController(MainShell mainShell, Variant variantApplication) {
		setMainShell(mainShell);
		setVariantApplication(variantApplication);
	}

	public Variant getVariantApplication() {
		return variantApplication;
	}

	public void setVariantApplication(Variant variantApplication) {
		this.variantApplication = variantApplication;
	}

	public MainShell getMainShell() {
		return mainShell;
	}

	public void setMainShell(MainShell mainShell) {
		this.mainShell = mainShell;
	}

	public void openSchoolFrame() {
		new SchoolController(this);
	}
	
	public Word getWord(){
		return new Word(getVariantApplication());
	}
	
	public void hideTaskPane(){
		Variant taskPanes = OleUtils.INSTANCE.getProperty(variantApplication.getAutomation(), "TaskPanes");
		int count = OleUtils.INSTANCE.countElementInCollection(taskPanes.getAutomation());
		/*
		 * The count is =  to 20. In VBA the collectiosn are One Based, but it's look like a Bug.
		 * So to Avoid null pointer, I test if the task pane is <code>null</code>.
		 */
		for (int i = 1; i < count;i++){
			Variant taskPane = OleUtils.INSTANCE.getElementInCollection(taskPanes.getAutomation(), i);
			if (taskPane != null){
				OleUtils.INSTANCE.setProperty(taskPane.getAutomation(), "Visible", new Variant(false));
			}
		}
	}
}
