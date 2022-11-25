package com.example.demo.service;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;

	@Override
	public byte[] getOneImage(Long id) {
		imageRepository.findById(id).
				orElseThrow(() -> new IllegalStateException("image with " + id + " doesn't exist"));
		return imageRepository.findById(id).get().getFile();
	}
	@Override
	public Image saveImage(MultipartFile multipartFile) throws IOException {
		Image image = new Image(
				multipartFile.getOriginalFilename(),
				multipartFile.getContentType(),
				multipartFile.getBytes()
		);

		return imageRepository.save(image);	}

	@Override
	public List<Image> findAll() {
		return (List<Image>) imageRepository.findAll();
	}
}
