package com.alone.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	Map<?, ?> uploadPicture(MultipartFile uploadFile);
}

