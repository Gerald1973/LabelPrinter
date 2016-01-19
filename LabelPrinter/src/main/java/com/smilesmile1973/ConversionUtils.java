package com.smilesmile1973;

public enum ConversionUtils {
	INSTANCE;

	public int cmToPoint(float cm) {
		int result = 0;
		result = (int) Math.floor(cm * (float) Constants.NUMBER_OF_POINTS_BY_CM);
		return result;
	}

	public float pointToCm(int point) {
		float result = 0;
		result = point / Constants.NUMBER_OF_POINTS_BY_CM;
		return roundToNDecimals(result, Constants.SCALE);
	}

	public float roundToNDecimals(float value, int nDecimals) {
		int tmp = (int) Math.pow(10, nDecimals);
		float result = (float) Math.floor(value * tmp) / (float) tmp;
		return result;
	}
}
