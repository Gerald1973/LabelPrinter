package com.smilesmile1973.ms.word;

import org.eclipse.swt.ole.win32.Variant;

import com.smilesmile1973.Constants;
import com.smilesmile1973.ConversionUtils;
import com.smilesmile1973.OleUtils;

/**
 * This class refers the PageSetup bject of the Document.
 * 
 * @author marechal
 */
public class PageSetup extends AbstractOleWordObject<Document> {

	public PageSetup(Document parent, Variant myVariant) {
		super(parent, myVariant);
	}

	/**
	 * This method set up the page.
	 * 
	 * @param paperSize
	 *            a constant WdPaperSize
	 * @author marechal
	 */
	public void setPaperSize(int paperSize) {
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "PaperSize", new Variant(paperSize));
	}

	public void setLeftMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "LeftMargin", new Variant(numberOfPoints));
	}

	public void setRightMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "RightMargin", new Variant(numberOfPoints));
	}

	public void setTopMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "TopMargin", new Variant(numberOfPoints));
	}

	public void setBottomMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "BottomMargin", new Variant(numberOfPoints));
	}

	public void setHeaderMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "HeaderMargin", new Variant(numberOfPoints));
	}

	public void setFooterMargin(float cm) {
		int numberOfPoints = ConversionUtils.INSTANCE.cmToPoint(cm);
		OleUtils.INSTANCE.setProperty(getMyVariant().getAutomation(), "FooterMargin", new Variant(numberOfPoints));
	}

	public float getPageWidth() {
		float result = 0;
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "PageWidth");
		result = ConversionUtils.INSTANCE.pointToCm(tmp.getInt());
		return result;
	}

	public float getHeight() {
		float result = 0;
		Variant tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "PageHeight");
		result = ConversionUtils.INSTANCE.pointToCm(tmp.getInt());
		return result;
	}

	/**
	 * @return the top margin of the page in cm.
	 */
	public float getTopMargin() {
		float result = 0;
		int tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "TopMargin").getInt();
		result = ConversionUtils.INSTANCE.roundToNDecimals(ConversionUtils.INSTANCE.pointToCm(tmp), Constants.SCALE);
		return result;
	}

	/**
	 * @return the right margin of the page in cm.
	 */
	public float getRightMargin() {
		float result = 0;
		int tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "RightMargin").getInt();
		result = ConversionUtils.INSTANCE.roundToNDecimals(ConversionUtils.INSTANCE.pointToCm(tmp), Constants.SCALE);
		return result;
	}

	/**
	 * @return the bottom margin of the page in cm.
	 */
	public float getBottomMargin() {
		float result = 0;
		int tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "BottomMargin").getInt();
		result = ConversionUtils.INSTANCE.roundToNDecimals(ConversionUtils.INSTANCE.pointToCm(tmp), Constants.SCALE);
		return result;
	}

	/**
	 * @return the left margin of the page in cm.
	 */
	public float getLeftMargin() {
		float result = 0;
		int tmp = OleUtils.INSTANCE.getProperty(getMyVariant().getAutomation(), "LeftMargin").getInt();
		result = ConversionUtils.INSTANCE.roundToNDecimals(ConversionUtils.INSTANCE.pointToCm(tmp), Constants.SCALE);
		return result;
	}
}