package com.smilesmile1973.view.school;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

import com.smilesmile1973.model.school.SchoolModel;

public class SchoolFrame {
	private static Shell shell = null;
	private final MainPanel mainPanel;

	public SchoolFrame(SchoolModel model) {
		shell = new Shell(SWT.SHELL_TRIM & ~SWT.RESIZE);
		shell.setText(model.getShellTitle());
		shell.setLayout(new GridLayout());
		mainPanel = new MainPanel(shell, SWT.NONE, model);
		shell.pack();
	}

	public void setVisible(boolean isVisible) {
		shell.setVisible(isVisible);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void dispose() {
		shell.dispose();
	}

	public String getCourseValue() {
		String result = "";
		if (StringUtils.isNoneEmpty(getMainPanel().getCourseValue())) {
			result = getMainPanel().getCourseValue();
		}
		return result;
	}

	public String getFirstNameValue() {
		String result = "";
		if (StringUtils.isNoneEmpty(getMainPanel().getFirstNameValue())) {
			result = getMainPanel().getFirstNameValue().trim();
		}
		return result;
	}

	public String getFamilyNameValue() {
		String result = "";
		if (StringUtils.isNoneEmpty(getMainPanel().getFamilyNameValue())) {
			result = getMainPanel().getFamilyNameValue().trim();
		}
		return result;
	}

	public String getRoomValue() {
		String result = "";
		if (StringUtils.isNoneEmpty(getMainPanel().getRoomValue())) {
			result = getMainPanel().getRoomValue().trim();
		}
		return result;
	}
}
