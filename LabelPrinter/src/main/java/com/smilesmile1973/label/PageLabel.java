package com.smilesmile1973.label;

/**
 * This class represent a page label. This is a sheet wit every labels.
 * 
 * @author marechal
 *
 */
public class PageLabel {
	private StickLabel stickLabel;
	private float width;
	private float height;
	private float interLabelWidth;
	private float interLabelHeight;
	private float marginLeft;
	private float marginRight;
	private float marginTop;
	private float marginBottom;
	private int numberOfLabelWidth;
	private int numberOfLabelHeight;
	private int numberOfColumns;
	private int numberOfRows;
	private CellPageLabel[][] cellDimensions;

	/**
	 * This constructor initialise a page of labels with the given data.
	 * 
	 * @param width
	 *            the width of the page in cm.
	 * @param height
	 *            the height of the page in cm.
	 * @param marginTop
	 *            the top margin of the page in cm.
	 * @param marginRight
	 *            the right margin of the page in cm.
	 * @param marginBottom
	 *            the bottom margin in cm.
	 * @param marginLeft
	 *            the left margin in cm.
	 * @param stickLabel
	 *            the {@link StickLabel}, can not be <code>null</code>
	 * @author marechal
	 */
	public PageLabel(float width, float height, float marginTop, float marginRight, float marginBottom,
			float marginLeft, StickLabel stickLabel) {
		this.width = width;
		this.height = height;
		this.stickLabel = stickLabel;
		this.marginTop = marginTop;
		this.marginRight = marginRight;
		this.marginBottom = marginBottom;
		this.marginLeft = marginLeft;
		this.numberOfLabelHeight = calculateNumberOfLabelHeight(stickLabel);
		this.numberOfLabelWidth = calculateNumberOfLabelWidth(stickLabel);
		this.interLabelWidth = calculateInterLabelWidth(stickLabel, this.numberOfLabelWidth);
		this.interLabelHeight = calculateInterLabelHeight(stickLabel, this.numberOfLabelHeight);
		this.numberOfColumns = calculateNumberOfColumns(stickLabel, numberOfLabelWidth, interLabelWidth);
		this.numberOfRows = calculateNumberOfRows(stickLabel, numberOfLabelHeight, interLabelHeight);
		buildCellDimensions(numberOfRows, numberOfColumns);
	}

	private void buildCellDimensions(int numberOfRows, int numberOfColumns) {
		cellDimensions = new CellPageLabel[numberOfRows][numberOfColumns];
		float tmpHeight = 0;
		float tmpWidth = 0;
		boolean tmpIsLabel = false;
		for (int i = 0; i < numberOfRows; i++) {
			if (getInterLabelHeight() > 0) {
				if (i % 2 == 1) {
					tmpHeight = getInterLabelHeight();
				} else {
					tmpHeight = getStickLabel().getHeight();
				}
			} else {
				tmpHeight = getStickLabel().getHeight();
			}
			for (int j = 0; j < numberOfColumns; j++) {
				if (getInterLabelWidth() > 0) {
					if (j % 2 == 1) {
						tmpWidth = getInterLabelWidth();
						tmpIsLabel = false;
					} else {
						tmpWidth = getStickLabel().getWidth();
						tmpIsLabel = (i%2 == 0) && (j%2 == 0);
					}
				} else {
					tmpWidth = getStickLabel().getWidth();
				}
				
				cellDimensions[i][j] = new CellPageLabel(tmpWidth, tmpHeight,tmpIsLabel);
			}
		}
	}

	private int calculateNumberOfLabelWidth(StickLabel stickLabel) {
		int result = 0;
		result = (int) Math.floor((width - (this.marginLeft + this.marginRight)) / stickLabel.getWidth());
		return result;
	}

	private int calculateNumberOfLabelHeight(StickLabel stickLabel) {
		int result = 0;
		result = (int) Math.floor((height - (this.marginTop + this.marginBottom)) / stickLabel.getHeight());
		return result;
	}

	private float calculateInterLabelWidth(StickLabel stickLabel, int numberOfLabelWidth) {
		float result = 0;
		float usedSpace = numberOfLabelWidth * stickLabel.getWidth();
		float freeSpace = this.width - (this.marginRight + this.marginLeft) - usedSpace;
		result = freeSpace / (numberOfLabelWidth - 1);
		return result;
	}

	private float calculateInterLabelHeight(StickLabel stickLabel, int numberOfLabelHeight) {
		float result = 0;
		float usedSpace = numberOfLabelHeight * stickLabel.getHeight();
		float freeSpace = this.height - (this.marginTop + this.marginBottom) - usedSpace;
		result = freeSpace / (numberOfLabelHeight - 1);
		return result;
	}

	private int calculateNumberOfColumns(StickLabel stickLabel, int numberOfLabelWidth, float interLabelWidth) {
		int result = numberOfLabelWidth;
		if (interLabelWidth != 0) {
			result = result + numberOfLabelWidth - 1;
		}
		return result;
	}

	private int calculateNumberOfRows(StickLabel stickLabel, int numberOfLabelHeight, float interLabelHeight) {
		int result = numberOfLabelHeight;
		if (interLabelHeight != 0) {
			result = result + numberOfLabelHeight - 1;
		}
		return result;
	}

	public StickLabel getStickLabel() {
		return stickLabel;
	}

	public void setStickLabel(StickLabel stickLabel) {
		this.stickLabel = stickLabel;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getInterLabelWidth() {
		return interLabelWidth;
	}

	public void setInterLabelWidth(float interLabelWidth) {
		this.interLabelWidth = interLabelWidth;
	}

	public float getInterLabelHeight() {
		return interLabelHeight;
	}

	public void setInterLabelHeight(float interLabelHeight) {
		this.interLabelHeight = interLabelHeight;
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

	public float getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(float marginTop) {
		this.marginTop = marginTop;
	}

	public float getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(float marginBottom) {
		this.marginBottom = marginBottom;
	}

	public int getNumberOfLabelWidth() {
		return numberOfLabelWidth;
	}

	public void setNumberOfLabelWidth(int numberOfLabelWidth) {
		this.numberOfLabelWidth = numberOfLabelWidth;
	}

	public int getNumberOfLabelHeight() {
		return numberOfLabelHeight;
	}

	public void setNumberOfLabelHeight(int numberOfLabelHeight) {
		this.numberOfLabelHeight = numberOfLabelHeight;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public CellPageLabel[][] getCellDimensions() {
		return cellDimensions;
	}

	public void setCellDimensions(CellPageLabel[][] cellDimensions) {
		this.cellDimensions = cellDimensions;
	}

}
