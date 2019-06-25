package com.yuxi.photo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.service.exception.ServiceException;
import com.yuxi.photo.util.Validations;

/** Implementation of FileService Interface
 * @author Jorge Aguirre
 *
 */
@Service
public class FileServiceImpl implements FileService {
	
	private static final String AMOUNT_ATRBS_MSG = "Invalid amount of attributes";
	private static final String PHOTO_NAME_ERROR_MSG = "Invalid photo name";
	private static final String CITY_NAME_ERROR_MSG = "Invalid city name";
	private static final String LOCAL_DATE_TIME_ERROR_MSG = "Invalid date format";
	private static final String EXTENSION_ERROR_MSG = "Invalid extension";
	private static final String PHOTO_FILENAME_ERROR_MSG = "Invalid photo filename";

	/* (non-Javadoc)
	 * @see com.yuxi.photo.service.FileService#getPhotosFromFile(java.lang.String)
	 */
	@Override
	public List<Photo> getPhotosFromFile(String filePath) throws ServiceException {
		
		Path path = Paths.get(filePath);
		List<Photo> photos = new ArrayList<Photo>();
		AtomicInteger index = new AtomicInteger();
	    try {
	        photos = Files.lines(path)
	        	    .map(a -> {
						try {
							return mapObject(a.split(","), index.getAndIncrement());
						} catch (ServiceException e) {
							e.printStackTrace();
						}
						return null;
					})
	        	    .filter(a -> a != null)
	        		.collect(Collectors.toList());
	    }
	    catch(Exception ex) {
	       throw new ServiceException(ex);
	    }
	    
		return photos;
	}

	private Photo mapObject(String[] photoInfo, int index) throws ServiceException {
		
		String photoName;
		String extension;
		String cityName;
		LocalDateTime dateTaken;
		
		if (!Validations.validateAmoungAtrbs(photoInfo)) {
			throw new ServiceException(AMOUNT_ATRBS_MSG);
		}
		
		if (!Validations.validatePhotoFilename(photoInfo[0])) {
			throw new ServiceException(PHOTO_FILENAME_ERROR_MSG);
		}
		
		String[] photoNameParts = photoInfo[0].split("\\.");
		
		if (!Validations.validatePhotoFilename(photoInfo[0])) {
			throw new ServiceException(PHOTO_NAME_ERROR_MSG);
		}
		
		photoName = StringUtils.trim(photoNameParts[0]);
		
		if (!Validations.validateExtension(photoNameParts[1])) {
			throw new ServiceException(EXTENSION_ERROR_MSG);
		}
		
		extension = StringUtils.trim(photoNameParts[1]);
		
		if (!Validations.validateCityName(photoInfo[1])) {
			throw new ServiceException(CITY_NAME_ERROR_MSG);
		}
		
		cityName = StringUtils.trim(photoInfo[1]);
		
		try {
			dateTaken = LocalDateTime.parse(StringUtils.trim(photoInfo[2]), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		} catch (DateTimeParseException e) {
			throw new ServiceException(LOCAL_DATE_TIME_ERROR_MSG);
		}
		
		return new Photo(photoName, extension, cityName, dateTaken, index);
		
	}
	
}
