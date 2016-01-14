package com.smilesmile1973;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.internal.ole.win32.TYPEATTR;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.Variant;

/**
 * This singleton enum, contains a bunch of method Used to comunicate with OLE.
 * 
 * @author marechal
 *
 */
public enum OleUtils {
	INSTANCE;

	/**
	 * This method returns the {@link Variant} corresponding the Word
	 * application. The Application object is the root of every object in the
	 * ole application.
	 * 
	 * @param clientSite
	 *            the site of Word for the ole document, can not be
	 *            <code>null</code>
	 * @return a {@link Variant} containing the object Application, or
	 *         <code>null</code>.
	 * @author marechal
	 */
	public Variant getWordApplication(OleClientSite clientSite) {
		OleAutomation oleAutomation = new OleAutomation(clientSite);
		return getProperty(oleAutomation, "Application");
	}

	/**
	 * Utility method to get a property from an object
	 * 
	 * @param oleAutomation
	 *            the given {@link OleAutomation} to access the object.
	 * @param propertyName
	 *            the property to fetch.
	 * @return the {@link Variant} for the given property or <code>null</code>
	 *         if the property is not found.
	 * @author marechal
	 */
	public Variant getProperty(OleAutomation oleAutomation, String propertyName) {
		Variant result;
		String[] propertyNames = new String[1];
		propertyNames[0] = propertyName;
		int[] tmpPropertyId = oleAutomation.getIDsOfNames(propertyNames);
		if (tmpPropertyId == null) {
			result = null;
		} else {
			result = oleAutomation.getProperty(tmpPropertyId[0]);
		}
		return result;
	}

	/**
	 * Utility method to set a propery in a ole object.
	 * 
	 * @param oleAutomation
	 *            the given {@link OleAutomation} to access the object.
	 * @param propertyName
	 *            the property to set.
	 * @param value
	 *            the value to assign to the property.
	 * @return <code>true</code> if the operation was successfull otherwise
	 *         <code>false</code>
	 * @author marechal
	 */
	public boolean setProperty(OleAutomation oleAutomation, String propertyName, Variant value) {
		boolean result = false;
		String[] propertyNames = new String[1];
		propertyNames[0] = propertyName;
		int[] tmpPropertyId = oleAutomation.getIDsOfNames(propertyNames);
		if (tmpPropertyId != null) {
			result = oleAutomation.setProperty(tmpPropertyId[0], value);
		}
		return result;
	}

	/**
	 * This utility method returns the {@link Variant} corresponding to the
	 * index in the given collection.
	 * 
	 * @param oleAutomation
	 *            the {@link OleAutomation} of the given collection.
	 * @param index
	 *            based on 1
	 * @return the {@link Variant} corresponding to the index in the given
	 *         collection.
	 */
	public Variant getElementInCollection(OleAutomation oleAutomation, int index) {
		String methodName = "Item";
		Variant result = null;
		String[] methodNames = new String[1];
		methodNames[0] = methodName;
		int[] itemMethodId = oleAutomation.getIDsOfNames(methodNames);
		Variant[] variants = new Variant[1];
		variants[0] = new Variant(index);
		result = oleAutomation.invoke(itemMethodId[0], variants);
		return result;
	}

	/**
	 * This method return a variant by calling the method on the given
	 * {@link OleAutomation}.
	 * 
	 * @param oleAutomation
	 *            the given {@link OleAutomation}
	 * @param methodName
	 *            the name of the method to execute.
	 * @param variants
	 *            the parameters to pas to the method.
	 * @return a {@link Variant}
	 * @author marechal
	 */
	public Variant executeMethod(OleAutomation oleAutomation, String methodName, Variant[] variants) {
		Variant result = null;
		String[] methodNames = new String[1];
		methodNames[0] = methodName;
		int[] methodIds = oleAutomation.getIDsOfNames(methodNames);
		result = oleAutomation.invoke(methodIds[0], variants);
		return result;
	}

	/**
	 * Helper method, to display very members of an {@link OleAutomation}
	 * 
	 * @param ole
	 *            the given {@link OleAutomation}
	 * @author marechal
	 */
	public void printAllFunc(OleAutomation ole) {
		TYPEATTR typeAttr = ole.getTypeInfoAttributes();
		int numberOfFunction = typeAttr.cFuncs;
		for (int i = 0; i < numberOfFunction; i++) {
			System.out.println(ole.getFunctionDescription(i).name);
		}
	}

	/**
	 * This method convert an array of integer values to an array of
	 * {@link Variant}
	 * 
	 * @param values
	 *            the value to convert.
	 * @return an array of {@link Variant}
	 */
	public Variant[] buildArrayOfVariant(int... values) {
		List<Variant> variants = new ArrayList<Variant>();
		for (int i = 0; i < values.length; i++) {
			variants.add(new Variant(values[i]));
		}
		return variants.toArray(new Variant[variants.size()]);
	}

	/**
	 * This method convert an array of integer values to an array of
	 * {@link Variant}
	 * 
	 * @param values
	 *            the value to convert.
	 * @return an array of {@link Variant}
	 */
	public Variant[] buildArrayOfVariant(long... values) {
		List<Variant> variants = new ArrayList<Variant>();
		for (int i = 0; i < values.length; i++) {
			variants.add(new Variant(values[i]));
		}
		return variants.toArray(new Variant[variants.size()]);
	}

}
