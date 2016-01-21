package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class View extends AbstractOleWordObject<Window> {
	public View(Window parent, Variant myVariant) {
		super(parent, myVariant);
	}

	public void setShowDrawings(boolean b) {
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "ShowDrawings", new Variant(b));
	}
}
