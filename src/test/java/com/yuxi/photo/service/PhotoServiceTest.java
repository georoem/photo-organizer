package com.yuxi.photo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.rest.model.PhotoServiceResponse;
import com.yuxi.photo.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoServiceTest {
	
	private PhotoService photoService;
	
	@PostConstruct
	public void init() {
		photoService = new PhotoServiceImpl();
	}
	
	@Test
	public void organizePhotoListFromFileTest() throws ServiceException {
		PhotoServiceResponse response = photoService.organizePhotos(photos());
		assertNotNull(response);
		assertEquals("Medellin4.jpg", response.getNames().get(0).getNewName());
		assertEquals("Bogota4.jpg", response.getNames().get(1).getNewName());
		assertEquals("Cartago4.jpg", response.getNames().get(2).getNewName());
	}

	private List<Photo> photos() {
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(new Photo("uno", "jpg", "Medellin", LocalDateTime.now().minusDays(1), 1));
		photos.add(new Photo("dos", "jpg", "Bogota", LocalDateTime.now().minusDays(2), 2));
		photos.add(new Photo("tres", "jpg", "Cartago", LocalDateTime.now().minusDays(3), 3));
		photos.add(new Photo("cuatro", "jpg", "Medellin", LocalDateTime.now().minusDays(4), 4));
		photos.add(new Photo("cinco", "jpg", "Bogota", LocalDateTime.now().minusDays(5), 5));
		photos.add(new Photo("seis", "jpg", "Cartago", LocalDateTime.now().minusDays(6), 6));
		photos.add(new Photo("siete", "jpg", "Medellin", LocalDateTime.now().minusDays(7), 7));
		photos.add(new Photo("ocho", "jpg", "Bogota", LocalDateTime.now().minusDays(8), 8));
		photos.add(new Photo("nueve", "jpg", "Cartago", LocalDateTime.now().minusDays(9), 9));
		photos.add(new Photo("diez", "jpg", "Medellin", LocalDateTime.now().minusDays(10), 10));
		photos.add(new Photo("once", "jpg", "Bogota", LocalDateTime.now().minusDays(11), 11));
		photos.add(new Photo("doce", "jpg", "Cartago", LocalDateTime.now().minusDays(12), 12));
		return photos;
	}

}
