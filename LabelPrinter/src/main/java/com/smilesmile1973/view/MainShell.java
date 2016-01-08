package com.smilesmile1973.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.smilesmile1973.OleUtils;
import com.smilesmile1973.controller.MainController;

public class MainShell {
	private OleFrame wordFrame;
	private OleClientSite clientSite;
	private MainController mainController;
	private final ToolBar toolBar;
	

	public MainShell() {
		Display display = new Display();
		final Shell shell = new Shell(display);
		GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		
		toolBar = new ToolBar(shell,SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		GridData gridDataToolBar = new GridData();
		gridDataToolBar.horizontalAlignment=SWT.FILL;
		gridDataToolBar.grabExcessHorizontalSpace=true;
		toolBar.setLayoutData(gridDataToolBar);
		ToolItem itemShowLabelDialog = new ToolItem(toolBar, SWT.PUSH);
		itemShowLabelDialog.setText("Open label creator");
		wordFrame = new OleFrame(shell, SWT.NONE);
		GridData gridDataWordFrame = new GridData();
		gridDataWordFrame.widthHint=800;
		gridDataWordFrame.heightHint=600;
		gridDataWordFrame.horizontalAlignment=SWT.FILL;
		gridDataWordFrame.verticalAlignment=SWT.FILL;
		gridDataWordFrame.grabExcessHorizontalSpace=true;
		gridDataWordFrame.grabExcessVerticalSpace=true;
		wordFrame.setLayoutData(gridDataWordFrame);
		clientSite = new OleClientSite(wordFrame, SWT.NONE, "Word.Document");
		clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
		Variant application = OleUtils.INSTANCE.getWordApplication(clientSite);
		mainController = new MainController(this,application);
		mainController.setMainShell(this);
		mainController.setVariantApplication(application);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
