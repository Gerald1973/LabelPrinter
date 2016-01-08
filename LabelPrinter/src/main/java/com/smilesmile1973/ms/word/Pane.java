package com.smilesmile1973.ms.word;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Pane extends AbstractOleWordObject<Window>{
	
	public Pane(Window parent, Variant variant) {
		super(parent,variant);
	}

	public List<Page> getPages() {
		List<Page> results = new ArrayList<Page>();
		Variant pagesVariant = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Pages");
		int numberOfPages = pagesVariant.getInt();
		for (int i = 0; i < numberOfPages; i++) {
			Variant pageVariant = OleUtils.INSTANCE.getElementInCollection(pagesVariant.getAutomation(), i);
			Page page = new Page(this, pageVariant);
			results.add(page);
		}
		return results;
	}
}
