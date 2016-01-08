package com.smilesmile1973.label;

/**
 * All value needs to expressed in CM
 * 
 * @author marechal
 *
 */
public class PageLabel {
	private float width;
	private float height;
	private float marginHigh;
	private float marginDown;
	private float verticalSpace;
	private float horizontalSpace;
	private float marginLeft;
	private float marginRight;

	private PageLabel() {
		setWidth(6.35f);
		setHeight(3.81f);
		setVerticalSpace(0f);
		setHorizontalSpace(0f);
		setMarginHigh(0.104366929f);
		setMarginDown(0.104366929f);
		setMarginLeft(0.975001225f);
		setMarginRight(0.975001225f);
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getMarginHigh() {
		return marginHigh;
	}

	public void setMarginHigh(float marginHigh) {
		this.marginHigh = marginHigh;
	}

	public float getMarginDown() {
		return marginDown;
	}

	public void setMarginDown(float marginDown) {
		this.marginDown = marginDown;
	}

	public float getVerticalSpace() {
		return verticalSpace;
	}

	public void setVerticalSpace(float verticalSpace) {
		this.verticalSpace = verticalSpace;
	}

	public float getHorizontalSpace() {
		return horizontalSpace;
	}

	public void setHorizontalSpace(float horizontalSpace) {
		this.horizontalSpace = horizontalSpace;
	}

	public float getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(float marginLeft) {
		this.marginLeft = marginLeft;
	}

	public float getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(float marginRight) {
		this.marginRight = marginRight;
	}
}
