package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;

	private String type;

	@Column(length = 50000000)
	@Lob
	private byte[] file;

	public Image(String name, String type, byte[] file) {
		this.name = name;
		this.type = type;
		this.file = file;
	}
}
