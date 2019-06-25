package com.yuxi.photo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.yuxi.photo.rest.model.Photo;
import com.yuxi.photo.rest.model.PhotoNamesResponse;
import com.yuxi.photo.rest.model.PhotoServiceResponse;

/** Implementation of PhotoService Interface
 * @author Jorge Aguirre
 *
 */
@Service
public class PhotoServiceImpl implements PhotoService {
	
	/* (non-Javadoc)
	 * @see com.yuxi.photo.service.PhotoService#organizePhotos(java.util.List)
	 */
	@Override
	public PhotoServiceResponse organizePhotos(List<Photo> photos) {
		AtomicInteger index = new AtomicInteger(1); 
		
		List<PhotoNamesResponse> sortedNames = new ArrayList<PhotoNamesResponse>();
		
		Map<String, List<Photo>> mapPhoto = photos.stream()
				.sorted(
		                Comparator.comparing(Photo::getCityName, String::compareToIgnoreCase)
                        .thenComparing(Photo::getDateTaken, LocalDateTime::compareTo))
				.collect(Collectors.groupingBy(Photo::getCityName));
		
		for (String key : mapPhoto.keySet()) {
			int maxStringLength = String.valueOf(mapPhoto.get(key).size()).length();
			index.set(1);
			sortedNames.addAll(mapPhoto.get(key).stream().map(p -> {
				return new PhotoNamesResponse(p.getPhotoFilename(), getNewName(p, index.getAndIncrement(), maxStringLength), p.getOrderInFile());
			}).collect(Collectors.toList()));
		}
			
		return new PhotoServiceResponse(sortedNames.stream()
				.sorted(Comparator.comparing(PhotoNamesResponse::getOrder, Integer::compareTo))
				.collect(Collectors.toList()));
	}

	private String getNewName(Photo photo, int index, int maxStringLength) {
		return photo.getCityName()+StringUtils.leftPad(String.valueOf(index), maxStringLength, "0") + Photo.DOT + photo.getExtension();
	}

}
