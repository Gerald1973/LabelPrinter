package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Selection extends AbstractOleWordObject<Window> {
	public Selection(Window parent, Variant variant) {
		super(parent, variant);
	}

	public String getText() {
		String result = null;
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Text");
		if (tmp != null) {
			result = tmp.getString();
		}
		return result;
	}

	public boolean setText(String text) {
		return OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "Text", new Variant(text));
	}
	
}
