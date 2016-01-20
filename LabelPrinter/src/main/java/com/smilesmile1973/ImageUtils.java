package com.smilesmile1973;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public enum ImageUtils {
	INSTANCE;

	public Image ImageScale(Image image, int width, int height) {
		ImageData data = image.getImageData();
		data = data.scaledTo(width, width);
		Image scaled = new Image(Display.getDefault(), data);
		image.dispose();
		return scaled;
	}
	
	public Image loadFromInternalResources(String fileName){
		InputStream in = this.getClass().getResourceAsStream("/com/smilesmile1973/icons/"+fileName);
		ImageData imageData = new ImageData(in);
		Image result = new Image(Display.getDefault(),imageData);
		return result;
	}
}
