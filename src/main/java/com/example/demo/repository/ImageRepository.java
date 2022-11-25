package com.example.demo.repository;

import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ImageRepository extends JpaRepository<Image,Long> {
}
