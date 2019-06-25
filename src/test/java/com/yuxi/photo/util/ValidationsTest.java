package com.yuxi.photo.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationsTest {
	
	private static final String VALID_DATE_TAKEN = "2013-09-05 14:08:15";
	private static final String VALID_CITY_NAME = "Warsaw";
	private static final String VALID_PHOTO_FILENAME = "photo.jpg";
	private static final String VALID_PHOTO_NAME = "photo";
	private static final String VALID_EXTENSION = "jpg";
	private static final String INVALID_PHOTO_NAME = "photo&";
	private static final String INVALID_EXTENSION = "tar";
	private static final String INVALID_CITY_NAME = "warsaw";

	@Test
	public void moreAmoungAttributesTest() {
		String[] photoInfo = {VALID_PHOTO_FILENAME, VALID_CITY_NAME, VALID_DATE_TAKEN, VALID_CITY_NAME};
		boolean isValid = Validations.validateAmoungAtrbs(photoInfo);
		assertFalse(isValid);
	}
	
	@Test
	public void lessAmoungAttributesTest() {
		String[] photoInfo = {VALID_PHOTO_FILENAME, VALID_CITY_NAME};
		boolean isValid = Validations.validateAmoungAtrbs(photoInfo);
		assertFalse(isValid);
	}
	
	@Test
	public void validAmoungAttributesTest() {
		String[] photoInfo = {VALID_PHOTO_FILENAME, VALID_CITY_NAME, VALID_DATE_TAKEN};
		boolean isValid = Validations.validateAmoungAtrbs(photoInfo);
		assertTrue(isValid);
	}
	
	@Test
	public void validPhotoNameTest() {
		boolean isValid = Validations.validatePhotoName(VALID_PHOTO_NAME);
		assertTrue(isValid);
	}
	
	@Test
	public void validExtensionTest() {
		boolean isValid = Validations.validateExtension(VALID_EXTENSION);
		assertTrue(isValid);
	}
	
	@Test
	public void validCityNameTest() {
		boolean isValid = Validations.validateCityName(VALID_CITY_NAME);
		assertTrue(isValid);
	}
	
	@Test
	public void invalidPhotoNameTest() {
		boolean isValid = Validations.validatePhotoName(INVALID_PHOTO_NAME);
		assertFalse(isValid);
	}
	
	@Test
	public void invalidExtensionTest() {
		boolean isValid = Validations.validateExtension(INVALID_EXTENSION);
		assertFalse(isValid);
	}
	
	@Test
	public void invalidCityNameTest() {
		boolean isValid = Validations.validateCityName(INVALID_CITY_NAME);
		assertFalse(isValid);
	}
	
}
