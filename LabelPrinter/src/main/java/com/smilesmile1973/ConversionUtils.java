package com.smilesmile1973;

public enum ConversionUtils {
	INSTANCE;
	
	public int cmToPoint(float cm){
		int result = 0;
		result = Math.round(cm * (float) Constants.NUMBER_OF_POINTS_BY_CM);
		return result;
	}
}
