package com.yuxi.photo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.yuxi.photo.PhotoSettings;
import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.rest.model.PhotoServiceResponse;
import com.yuxi.photo.service.FileService;
import com.yuxi.photo.service.PhotoService;
import com.yuxi.photo.service.exception.ServiceException;

/** Controller with Rest Api implementation
 * @author Jorge Aguirre
 *
 */
@Controller
public class PhotoRestController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PhotoSettings settings;

	@RequestMapping(value = "/photos", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PhotoServiceResponse> organizePhotos() throws ServiceException {	
		
		List <Photo> photos = fileService.getPhotosFromFile(settings.getFileName());
		
		PhotoServiceResponse response = photoService.organizePhotos(photos);
		
		return new ResponseEntity<PhotoServiceResponse>(response, new HttpHeaders(), HttpStatus.OK);
    }
	
	@ExceptionHandler(value = { ServiceException.class})
	protected ResponseEntity<String> handleException(Exception ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
