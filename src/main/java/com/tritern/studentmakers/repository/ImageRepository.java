package com.tritern.studentmakers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tritern.studentmakers.entity.Image;

@EnableMongoRepositories
public interface ImageRepository extends MongoRepository<Image, Integer>{
	
	@Query("{'schoolOrcollegeId':?0,'imagename':?1}")
	Image findbyimage(String name,String choice);

}
