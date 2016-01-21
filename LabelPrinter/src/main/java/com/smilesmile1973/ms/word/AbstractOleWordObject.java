package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

public abstract class AbstractOleWordObject<P> {
	private P parent;
	private Variant myVariant;

	public P getParent() {
		return parent;
	}
	
	public void dispose(){
		myVariant.dispose();
	}

	protected void setParent(P parent) {
		this.parent = parent;
	}

	protected Variant getMyVariant() {
		return myVariant;
	}

	protected void setMyVariant(Variant myVariant) {
		this.myVariant = myVariant;
	}
	
	AbstractOleWordObject(P parent,Variant myVariant){
		setParent(parent);
		setMyVariant(myVariant);
	}
	
	
	
}
