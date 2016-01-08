package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Page extends AbstractOleWordObject<Pane> {

	public Page(Pane parent, Variant variant) {
		super(parent, variant);
	}

	public long getWidth() {
		long result = -1;
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Width");
		if (tmp != null) {
			result = tmp.getLong();
		}
		return result;
	}

	public long getHeight() {
		long result = -1;
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Height");
		if (tmp != null) {
			result = tmp.getLong();
		}
		return result;
	}
}
