package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/images")
@RestController
public class ImageController {

	@Autowired
	ImageServiceImpl imageService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	ResponseEntity<String> saveImage(@RequestParam("image") MultipartFile file) {
		try {
			imageService.saveImage(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(file.getOriginalFilename());
	}

	@GetMapping("/{id}")
	public HttpEntity<byte[]> getImage(@PathVariable Long id){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(imageService.getOneImage(id), httpHeaders, HttpStatus.OK);
	}

	@GetMapping
	public List<Image> getDocument() {
		return imageService.findAll();
	}


}