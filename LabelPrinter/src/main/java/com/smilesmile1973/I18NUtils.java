package com.smilesmile1973;

import java.util.ResourceBundle;

public enum I18NUtils {
	INSTANCE("com.smilesmile1973.labelprinter");
	
	private ResourceBundle resourceBundle;
	
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}


	private I18NUtils(String resourceBundleFile){
		System.out.println(this.getClass().getClassLoader().getResourceAsStream(".").toString());
		resourceBundle = ResourceBundle.getBundle(resourceBundleFile);
	}
}
