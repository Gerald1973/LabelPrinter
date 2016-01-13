package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Document extends AbstractOleWordObject<Word> {

	public Document(Word parent, Variant variant) {
		super(parent, variant);
	}

	public String getName() {
		String result = "";
		Variant name = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Name");
		result = name.getString();
		return result;
	}

	public Window getActiveWindow() {
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "ActiveWindow");
		return new Window(this, tmp);
	}

	public void addTable(int numberOfRow, int numberOfColumn) {
		Variant[] rangeVariants = new Variant[2];
		rangeVariants[0] = new Variant(0);
		rangeVariants[1] = new Variant(0);
		Variant range = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Range", rangeVariants);
		Variant tables = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Tables");
		Variant[] tableVariants = new Variant[3];
		tableVariants[0] = range;
		tableVariants[1] = new Variant(numberOfRow);
		tableVariants[2] = new Variant(numberOfColumn);
		OleUtils.INSTANCE.executeMethod(tables.getAutomation(), "Add", tableVariants);
	}
}
