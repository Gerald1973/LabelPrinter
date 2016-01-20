package com.smilesmile1973.view.school;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.smilesmile1973.ImageUtils;
import com.smilesmile1973.model.school.SchoolModel;

public class MainPanel extends Composite {
	private final Button browseButton;
	private final Button cancelButton;
	private final Button insertButton;
	private final Label labelImage;
	private final Label labelFirstName;
	private final Label labelFamilyName;
	private final Label labelCourse;
	private final Label labelClass;
	private final Text inputFirstName;
	private final Text inputFamilyName;
	private final Text inputCourse;
	private final Text inputClass;

	public MainPanel(Composite parent, int style, SchoolModel model) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		GridLayout gridLayout = new GridLayout(3, false);
		this.setLayout(gridLayout);
		// BrowseButton
		GridData browseButtonGridData = new GridData();
		browseButtonGridData.verticalAlignment = SWT.TOP;
		browseButton = new Button(this, SWT.PUSH);
		browseButton.setLayoutData(browseButtonGridData);
		browseButton.setToolTipText(model.getBrowse());
		Image imageBrowseButton = ImageUtils.INSTANCE.loadFromInternalResources("folder-2x.png");
		browseButton.setImage(imageBrowseButton);
		// Image
		labelImage = new Label(this, SWT.NONE);
		GridData labelGridData = new GridData(300, 300);
		labelImage.setLayoutData(labelGridData);
		labelImage.setSize(300, 300);
		labelImage.setText("IMAGE!!");
		// LblNom
		GridData compositeLayout = new GridData();
		compositeLayout.verticalAlignment = SWT.TOP;
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(compositeLayout);
		composite.setLayout(new GridLayout(2, false));
		// Firstname
		labelFirstName = new Label(composite, SWT.NONE);
		labelFirstName.setText(model.getFirstName());
		inputFirstName = new Text(composite, SWT.SINGLE);
		inputFirstName.setLayoutData(buildTxtLayoutData());
		// familyname
		labelFamilyName = new Label(composite, SWT.NONE);
		labelFamilyName.setLayoutData(new GridData(SWT.RIGHT));
		labelFamilyName.setText(model.getFamilyName());
		inputFamilyName = new Text(composite, SWT.NONE);
		inputFamilyName.setLayoutData(buildTxtLayoutData());
		// course
		labelCourse = new Label(composite, SWT.NONE);
		labelCourse.setText(model.getCourse());
		labelCourse.setLayoutData(new GridData(SWT.RIGHT));
		inputCourse = new Text(composite, SWT.NONE);
		inputCourse.setLayoutData(buildTxtLayoutData());
		// class
		labelClass = new Label(composite, SWT.NONE);
		labelClass.setLayoutData(new GridData(SWT.RIGHT));
		labelClass.setText(model.getRoom());
		inputClass = new Text(composite, SWT.NONE);
		inputClass.setLayoutData(buildTxtLayoutData());
		// CancelButton
		GridData cancelButtonGridData = new GridData();
		cancelButtonGridData.horizontalAlignment = SWT.LEFT;
		cancelButton = new Button(this, SWT.NONE);
		cancelButton.setText(model.getCancel());
		cancelButton.setLayoutData(cancelButtonGridData);
		// Empty
		new Label(this, SWT.NONE);
		// InsertButton
		GridData insertButtonGridData = new GridData();
		insertButtonGridData.horizontalAlignment = SWT.RIGHT;
		insertButton = new Button(this, SWT.NONE);
		insertButton.setText(model.getInsert());
		insertButton.setLayoutData(insertButtonGridData);
	}

	public void addInsertButtonListener(Listener listener) {
		insertButton.addListener(SWT.Selection, listener);
	}

	public void addCancelButtonListener(Listener listener) {
		cancelButton.addListener(SWT.Selection, listener);
	}

	public void addBrowsButtonListener(Listener listener) {
		browseButton.addListener(SWT.Selection, listener);
	}

	private GridData buildTxtLayoutData() {
		GridData result = new GridData();
		result.widthHint = 200;
		result.horizontalAlignment = SWT.FILL;
		return result;
	}

	public String getCourseValue() {
		return inputCourse.getText();
	}

	public String getFirstNameValue() {
		return inputFirstName.getText();
	}

	public String getFamilyNameValue() {
		return inputFamilyName.getText();
	}

	public String getRoomValue() {
		return inputClass.getText();
	}

	public void setImage(Image image) {
		Image tmpImage = null;
		tmpImage = ImageUtils.INSTANCE.ImageScale(image, labelImage.getSize().x, labelImage.getSize().y);
		labelImage.setImage(tmpImage);
	}

}
