package com.smilesmile1973.view.school;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

import com.smilesmile1973.model.school.SchoolModel;

public class SchoolFrame {
	private static Shell shell = null;
	private final  MainPanel mainPanel;
	public SchoolFrame(SchoolModel model){
		shell = new Shell( SWT.SHELL_TRIM & ~SWT.RESIZE );
		shell.setText(model.getShellTitle());
		shell.setLayout(new GridLayout());
		mainPanel = new MainPanel(shell, SWT.NONE,model);
		shell.pack();
	}
	
	public void setVisible(boolean isVisible){
		shell.setVisible(isVisible);
	}
}
