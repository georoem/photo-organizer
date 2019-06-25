package com.yuxi.photo.util;

import org.springframework.util.StringUtils;

public class Validations {
	
	private static final int AMOUNT_ATRBS = 3;
	private static final String PHOTO_NAME_REGEX = "[a-zA-Z]+";
	private static final String PHOTO_FILENAME_REGEX = "[a-zA-Z]+\\.[A-Za-z]{3}";
	private static final String CITY_NAME_REGEX = "[A-Z][a-z]+";
	private static final String EXTENSION_REGEX = "jpg|png|jpeg";
	
	public static boolean validateAmoungAtrbs(String[] a) {
		return a.length == AMOUNT_ATRBS ;
	}

	public static boolean validatePhotoName(String photoName) {
		return StringUtils.trimWhitespace(photoName).matches(PHOTO_NAME_REGEX);
	}

	public static boolean validateExtension(String extension) {
		return StringUtils.trimWhitespace(extension).toLowerCase().matches(EXTENSION_REGEX);
	}

	public static boolean validateCityName(String cityName) {
		return StringUtils.trimWhitespace(cityName).matches(CITY_NAME_REGEX);
	}

	public static boolean validatePhotoFilename(String photoFilename) {
		return StringUtils.trimWhitespace(photoFilename).matches(PHOTO_FILENAME_REGEX);
	}

}
