package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.Constants;
import com.smilesmile1973.ConversionUtils;
import com.smilesmile1973.OleUtils;

/**
 * This class represents a Table in a Word document.
 * 
 * @author marechal
 *
 */
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
	public void setSizeOfCell(int row, int column, float width, float height) {
		// 1. Transform the centimeter to point
		int widthInPoint = ConversionUtils.INSTANCE.cmToPoint(width);
		int heightInPoint = ConversionUtils.INSTANCE.cmToPoint(height);
		// 2. apply the new size to the selected cell
		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		// 2.1 Set the width
		tmps = OleUtils.INSTANCE.buildArrayOfVariant(widthInPoint, Constants.WDADJUSTNONE);
		OleUtils.INSTANCE.executeMethod(cell.getAutomation(), "SetWidth", tmps);
		// 2.2 Set the height
		tmps = OleUtils.INSTANCE.buildArrayOfVariant(heightInPoint, Constants.WDROWHEIGHTEXACTLY);
		OleUtils.INSTANCE.executeMethod(cell.getAutomation(), "SetHeight", tmps);
	}

	/**
	 * This method is used to set the border of a cell in a table.<br>
	 * For example:<br>
	 * ...<br>
	 * <code>int borderToDisplay = Constants.BORDERBOTTOM | Constants.BORDERLEFT | Constants.BORDERRIGHT | Constants.BORDERTOP;</code>
	 * <br>
	 * <code>table.setBorderCell(1, 1, Constants.WDLINESTYLESINGLE, Constants.WDLINEWIDTH025PT,borderToDisplay);</code>
	 * <br>
	 * ...<br>
	 * 
	 * @param row
	 *            the row of the cell
	 * @param column
	 *            the column of the cell
	 * @param wLineStyle
	 *            a {@link Constants} of LineStyle
	 * @param wdLineWidth
	 *            a {@link Constants} of lineWidth
	 * @param borderMask
	 *            a integer bitwised with the border constants.
	 * @see Constants#BORDERBOTTOM
	 * @see Constants#BORDERLEFT
	 * @see Constants#BORDERRIGHT
	 * @see Constants#BORDERSWNE
	 * @see Constants#BORDERNWSE
	 * @see Constants#BORDERTOP
	 */
	public void setBorderCell(int row, int column, int wLineStyle, int wdLineWidth, int borderMask) {
		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		Variant borders = OleUtils.INSTANCE.getProperty(cell.getAutomation(), "Borders");
		int numberOfBorder = OleUtils.INSTANCE.getProperty(borders.getAutomation(), "Count").getInt();
		for (int i = 1; i <= numberOfBorder; i++) {
			if ((borderMask >> (i - 1)) % 2 != 0) {
				Variant border = OleUtils.INSTANCE.getElementInCollection(borders.getAutomation(), i);
				OleUtils.INSTANCE.setProperty(border.getAutomation(), "LineStyle", new Variant(wLineStyle));
				OleUtils.INSTANCE.setProperty(border.getAutomation(), "LineWidth", new Variant(wdLineWidth));
			}
		}
	}

	/**
	 * This mthod add some texts in one cell.
	 * 
	 * @param row
	 *            the row 1 based.
	 * @param column
	 *            the column 1 based
	 * @param text
	 *            the text to display
	 */
	public void setTextInCell(int row, int column, String text) {
		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		Variant range = OleUtils.INSTANCE.getProperty(cell.getAutomation(), "Range");
		OleUtils.INSTANCE.executeMethod(range.getAutomation(), "InsertAfter", new Variant[] { new Variant(text) });
	}

	public void addPictureInCell(int row, int column, String picturePath) {
		picturePath = "C:\\Users\\marechal\\Downloads\\mustang.jpg";

		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		Variant cellRange = OleUtils.INSTANCE.getProperty(cell.getAutomation(), "Range");
		Variant inlineShapes = OleUtils.INSTANCE.getProperty(cellRange.getAutomation(), "InlineShapes");
		OleUtils.INSTANCE.executeMethod(inlineShapes.getAutomation(), "AddPicture",
				new Variant[] { new Variant(picturePath) });
		Variant variantInlineShape = OleUtils.INSTANCE.getElementInCollection(inlineShapes.getAutomation(), 1);
		Variant variantShape = OleUtils.INSTANCE.executeMethod(variantInlineShape.getAutomation(), "ConvertToShape",
				null);
		OleUtils.INSTANCE.setProperty(variantShape.getAutomation(), "LockAnchor", new Variant(true));
		OleUtils.INSTANCE.setProperty(variantShape.getAutomation(), "Width",
				new Variant(ConversionUtils.INSTANCE.cmToPoint(Constants.ICON_WITH_FOR_LABEL)));
		OleUtils.INSTANCE.setProperty(variantShape.getAutomation(), "Height",
				new Variant(ConversionUtils.INSTANCE.cmToPoint(Constants.ICON_HEIGHT_FOR_LABEL)));
		Variant wrapFormat = OleUtils.INSTANCE.getProperty(variantShape.getAutomation(), "WrapFormat");
		Variant distance = new Variant(ConversionUtils.INSTANCE.cmToPoint(Constants.DISTANCE_PICTURE));
		OleUtils.INSTANCE.setProperty(wrapFormat.getAutomation(), "Type", new Variant(Constants.WDWRAPSQUARE));
		OleUtils.INSTANCE.setProperty(variantShape.getAutomation(), "Top", distance);
		OleUtils.INSTANCE.setProperty(variantShape.getAutomation(), "Left", distance);
	}

	/**
	 * This method set the paddings inside the cell (margin inside cell).
	 * 
	 * @param row
	 *            the row, 1 based.
	 * @param column
	 *            the column, 1 based.
	 * @param top
	 *            the padding in cm.
	 * @param right
	 *            the padding in cm.
	 * @param bottom
	 *            the padding in cm.
	 * @param left
	 *            the padding in cm.
	 */
	public void setCellPadding(int row, int column, float top, float right, float bottom, float left) {
		Variant[] tmps = OleUtils.INSTANCE.buildArrayOfVariant(row, column);
		Variant cell = OleUtils.INSTANCE.executeMethod(getMyVariant().getAutomation(), "Cell", tmps);
		int topPadding = ConversionUtils.INSTANCE.cmToPoint(top);
		int rightPadding = ConversionUtils.INSTANCE.cmToPoint(right);
		int bottomPadding = ConversionUtils.INSTANCE.cmToPoint(bottom);
		int leftPadding = ConversionUtils.INSTANCE.cmToPoint(left);
		OleUtils.INSTANCE.setProperty(cell.getAutomation(), "TopPadding", new Variant(topPadding));
		OleUtils.INSTANCE.setProperty(cell.getAutomation(), "RightPadding", new Variant(rightPadding));
		OleUtils.INSTANCE.setProperty(cell.getAutomation(), "BottomPadding", new Variant(bottomPadding));
		OleUtils.INSTANCE.setProperty(cell.getAutomation(), "LeftPadding", new Variant(leftPadding));
	}
}
