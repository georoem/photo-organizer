package com.yuxi.photo.service;

import java.util.List;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.rest.model.PhotoServiceResponse;

/** Photo service interface
 * @author Jorge Aguirre
 *
 */
public interface PhotoService {

	/** Service for organize photo file names
	 * @param photos
	 * @return PhotoServiceResponse
	 */
	public PhotoServiceResponse organizePhotos(List<Photo> photos);
	
}

