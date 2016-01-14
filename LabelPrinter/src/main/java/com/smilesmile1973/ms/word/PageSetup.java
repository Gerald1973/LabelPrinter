package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class PageSetup extends AbstractOleWordObject<Document> {

	public PageSetup(Document parent, Variant myVariant) {
		super(parent, myVariant);
	}
	
	/**
	 * This method set up the page.
	 * @param paperSize a constant WdPaperSize
	 * @author marechal
	 */
	public void setPaperSize(int paperSize){
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "PaperSize", new Variant(paperSize));
	}

}
