package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

public class Table extends AbstractOleWordObject<Document> {

	Table(Document parent, Variant myVariant) {
		super(parent, myVariant);
	}

}
