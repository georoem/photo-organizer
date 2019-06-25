package com.yuxi.photo.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {
	
	private static final String FILE_PATH = "src/test/resources/testFile.txt";
	
	private FileService fileService;
	
	@PostConstruct
	public void init() {
		fileService = new FileServiceImpl();
	}
	
	@Test
	public void getPhotoListFromFileTest() throws ServiceException {
		List<Photo> photos = fileService.getPhotosFromFile(FILE_PATH);	
		assertNotNull(photos);
	}

}
