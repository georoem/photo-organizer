package com.yuxi.photo.service;

import java.util.List;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.service.exception.ServiceException;

/** File Service Interface
 * @author Jorge Aguirre
 *
 */
public interface FileService {

	/** Method fo get data from file
	 * @param filePath
	 * @return
	 * @throws ServiceException
	 */
	public List<Photo> getPhotosFromFile(String filePath) throws ServiceException;
}
