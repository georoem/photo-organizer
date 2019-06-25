package com.yuxi.photo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** Setting object
 * @author Jorge Aguirre
 *
 */
@Configuration
@ConfigurationProperties(prefix = "yuxi.settings")
public class PhotoSettings {
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
