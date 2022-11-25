package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ImageRepository extends JpaRepository<Image,Long> {
}
