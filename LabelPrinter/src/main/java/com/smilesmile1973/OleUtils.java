package com.smilesmile1973;

import org.eclipse.swt.internal.ole.win32.TYPEATTR;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.Variant;

public enum OleUtils {
	INSTANCE;

	public Variant getWordApplication(OleClientSite clientSite) {
		OleAutomation oleAutomation = new OleAutomation(clientSite);
		return getProperty(oleAutomation, "Application");
	}

	public Variant getProperty(OleAutomation ole, String propertyName) {
		Variant result;
		String[] propertyNames = new String[1];
		propertyNames[0] = propertyName;
		int[] tmpPropertyId = ole.getIDsOfNames(propertyNames);
		if (tmpPropertyId == null) {
			result = null;
		} else {
			result = ole.getProperty(tmpPropertyId[0]);
		}
		return result;
	}

	public boolean setProperty(OleAutomation ole, String propertyName, Variant value) {
		boolean result = false;
		String[] propertyNames = new String[1];
		propertyNames[0] = propertyName;
		int[] tmpPropertyId = ole.getIDsOfNames(propertyNames);
		if (tmpPropertyId != null) {
			result = ole.setProperty(tmpPropertyId[0], value);
		}
		return result;
	}

	public Variant getElementInCollection(OleAutomation ole, int index) {
		String methodName = "Item";
		Variant result = null;
		String[] methodNames = new String[1];
		methodNames[0] = methodName;
		int[] itemMethodId = ole.getIDsOfNames(methodNames);
		Variant[] variants = new Variant[1];
		variants[0] = new Variant(index);
		result = ole.invoke(itemMethodId[0], variants);
		return result;
	}

	public Variant executeMethod(OleAutomation ole, String methodName, Variant[] variants) {
		Variant result = null;
		String[] methodNames = new String[1];
		methodNames[0] = methodName;
		int[] methodIds = ole.getIDsOfNames(methodNames);
		result = ole.invoke(methodIds[0]);
		return result;
	}

	public void printAllFunc(OleAutomation ole) {
		TYPEATTR typeAttr = ole.getTypeInfoAttributes();
		int numberOfFunction = typeAttr.cFuncs;
		for (int i = 0; i < numberOfFunction; i++) {
			System.out.println(ole.getFunctionDescription(i).name);
		}
	}

}
