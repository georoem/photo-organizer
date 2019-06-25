package com.yuxi.photo.rest.model;

import java.util.List;

/** Model for response service
 * @author Jorge Aguirre
 *
 */
public class PhotoServiceResponse {
	
	private List<PhotoNamesResponse> names;

	public PhotoServiceResponse(List<PhotoNamesResponse> names) {
		this.names = names;
	}

	public List<PhotoNamesResponse> getNames() {
		return names;
	}

}
