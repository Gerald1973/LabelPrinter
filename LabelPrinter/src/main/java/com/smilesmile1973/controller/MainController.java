package com.smilesmile1973.controller;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.controller.school.SchoolController;
import com.smilesmile1973.view.MainShell;
import com.smilesmile1973.view.school.SchoolFrame;

public class MainController {
	private Variant variantApplication;
	private MainShell mainShell;

	public MainController(MainShell mainShell, Variant variantApplication) {
		setMainShell(mainShell);
		setVariantApplication(variantApplication);
	}

	public void printPageSize() {

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
		new SchoolController();
	}
}
