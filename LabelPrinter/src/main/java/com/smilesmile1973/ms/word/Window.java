package com.smilesmile1973.ms.word;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.OleUtils;

public class Window extends AbstractOleWordObject<Document>{
	
	public Window(Document parent, Variant myVariant) {
		super(parent,myVariant);
	}

	public List<Pane> getPanes() {
		List<Pane> results = new ArrayList<Pane>();
		Variant panes = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Panes");
		Variant count = OleUtils.INSTANCE.getProperty(panes.getAutomation(), "Count");
		for (int i = 0; i < count.getInt(); i++) {
			Variant pane = OleUtils.INSTANCE.getElementInCollection(panes.getAutomation(), i);
			Pane tmp = new Pane(this, pane);
			results.add(tmp);
		}
		return results;
	}
	
	public Selection getSelection(){
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "Selection");
		return new Selection(this, tmp);
	}

}
