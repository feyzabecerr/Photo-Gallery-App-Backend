package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

	public byte[] getOneImage(Long id);

	public Image saveImage(MultipartFile multipartFile) throws IOException;

	public List<Image> findAll();

}