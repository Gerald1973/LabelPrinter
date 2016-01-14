package com.smilesmile1973.label;

/**
 * This class will contains the basic information the width and the height Both
 * have to be entered in cm.
 * 
 * @author marechal
 *
 */
public class StickLabel {
	private float width;
	private float height;

	/**
	 * This method returns he width of the Label in centimeter.
	 * 
	 * @return the width of the label in centimeter
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Set the width of the label in centimeter
	 * 
	 * @param width
	 *            the width of the label in centimeter
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Returns the height of the label in centimeter.
	 * 
	 * @return the height of the label in centimeter.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Set the height of the label in centimeter
	 * 
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * The constructor
	 * 
	 * @param width
	 *            the width of the label in centimetr
	 * @param height
	 *            the height of the label in centimeter
	 */
	public StickLabel(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}

}
