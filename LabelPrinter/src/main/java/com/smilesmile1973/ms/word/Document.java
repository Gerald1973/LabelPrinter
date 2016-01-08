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
}
