package com.test.springPlusChatting.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import lombok.Data;

@Data
@Service
@ConfigurationProperties(prefix = "custom.fileupload")
public class CustomFileuploadProperites {
	private String path;
}
