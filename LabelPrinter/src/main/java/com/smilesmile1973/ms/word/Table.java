package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.Constants;
import com.smilesmile1973.ConversionUtils;
import com.smilesmile1973.OleUtils;

public class Table extends AbstractOleWordObject<Document> {

	Table(Document parent, Variant myVariant) {
		super(parent, myVariant);
	}
	
	/**
	 * This method will set the width and the height of the cell.
	 * 
	 * @param table
	 *            a {@link Variant} for the table.
	 * @param row
	 *            the of the table based on 1.
	 * @param column
	 *            the column in the table based on 1.
	 * @param height
	 *            the new height of the cell in cm.
	 * @param width
	 *            the new width of the cell in cm.
	 */
	public void setSizeOfCell(int row, int column, float height, float width) {
		// 1. Transform the centimeter to point
		int widthInPoint = ConversionUtils.INSTANCE.cmToPoint(width);
		int heightInPoint = ConversionUtils.INSTANCE.cmToPoint(width);
		// 2. apply the new size to the selected cell
		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		// 2.1 Set the width
		tmps = OleUtils.INSTANCE.buildArrayOfVariant(widthInPoint, Constants.WDADJUSTSAMEWIDTH);
		OleUtils.INSTANCE.executeMethod(cell.getAutomation(), "SetWidth", tmps);
		// 2.2 Set the height
		tmps = OleUtils.INSTANCE.buildArrayOfVariant(heightInPoint, Constants.WDROWHEIGHTEXACTLY);
		OleUtils.INSTANCE.executeMethod(cell.getAutomation(), "SetHeight", tmps);
	}

}
