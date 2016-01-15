package com.smilesmile1973.label;

public class CellPageLabel {
	float width;
	float height;
	boolean isLabel = false;

	public CellPageLabel(float width, float height,boolean isLabel) {
		super();
		this.width = width;
		this.height = height;
		this.isLabel = isLabel;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public boolean isLabel() {
		return isLabel;
	}

	public void setLabel(boolean isLabel) {
		this.isLabel = isLabel;
	}
}
