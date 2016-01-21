package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Word extends AbstractOleWordObject<Object> {

	public Word(Variant myVariant) {
		super(null, myVariant);
	}

	public Document getActiveDocument() {
		Document result = null;
		Variant activeDocument = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "ActiveDocument");
		if (activeDocument != null) {
			result = new Document(this, activeDocument);
		}
		return result;
	}

	public void showPrintDialog(int wdDialogConstants) {

		Variant dialogs = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Dialogs");
		Variant dialog = OleUtils.INSTANCE.getElementInCollection(dialogs.getAutomation(), wdDialogConstants);
		OleUtils.INSTANCE.executeMethod(dialog.getAutomation(), "Show");
		// OleUtils.INSTANCE.printAllFunc(getMyVariant().getAutomation());
	}
}
