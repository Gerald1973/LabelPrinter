package com.smilesmile1973.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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

import com.smilesmile1973.I18NUtils;
import com.smilesmile1973.ImageUtils;
import com.smilesmile1973.OleUtils;
import com.smilesmile1973.controller.MainController;

public class MainShell {
	private OleFrame wordFrame;
	private OleClientSite clientSite;
	private final MainController mainController;
	private final ToolBar toolBar;
	private final Display display;
	private final Variant application;
	final Shell shell;
	ToolItem itemPrint;
	ToolItem itemShowLabelDialog;

	public MainShell() {
		display = new Display();
		shell = new Shell(display);
		GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);
		toolBar = new ToolBar(shell, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		GridData gridDataToolBar = new GridData();
		gridDataToolBar.horizontalAlignment = SWT.FILL;
		gridDataToolBar.grabExcessHorizontalSpace = true;
		toolBar.setLayoutData(gridDataToolBar);
		itemPrint = new ToolItem(toolBar, SWT.PUSH);
		itemPrint.setImage(ImageUtils.INSTANCE.loadFromInternalResources("print-2x.png"));
		itemPrint.setToolTipText(I18NUtils.INSTANCE.getString("mainshell.print"));
		itemShowLabelDialog = new ToolItem(toolBar, SWT.PUSH);
		itemShowLabelDialog.setText("Open label creator");
		wordFrame = new OleFrame(shell, SWT.NONE);
		GridData gridDataWordFrame = new GridData();
		gridDataWordFrame.widthHint = 800;
		gridDataWordFrame.heightHint = 600;
		gridDataWordFrame.horizontalAlignment = SWT.FILL;
		gridDataWordFrame.verticalAlignment = SWT.FILL;
		gridDataWordFrame.grabExcessHorizontalSpace = true;
		gridDataWordFrame.grabExcessVerticalSpace = true;
		wordFrame.setLayoutData(gridDataWordFrame);
		clientSite = new OleClientSite(wordFrame, SWT.NONE, "Word.Document");
		clientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
		application = OleUtils.INSTANCE.getWordApplication(clientSite);
		mainController = new MainController(this, application);
		mainController.setMainShell(this);
		mainController.setVariantApplication(application);
		mainController.hideTaskPane();
		Rectangle rectangle = display.getPrimaryMonitor().getBounds();
		shell.setSize(rectangle.width, rectangle.height);
		shell.setLocation(rectangle.x, rectangle.y);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public Shell getShell() {
		return shell;
	}

	public Display getDisplay() {
		return display;
	}

	public void addPrintListener(Listener listener) {
		itemPrint.addListener(SWT.Selection, listener);
	}

	public void addShowLabelDialogListener(Listener listener) {
		itemShowLabelDialog.addListener(SWT.Selection, listener);
	}
}
