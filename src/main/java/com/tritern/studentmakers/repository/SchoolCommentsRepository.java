package com.tritern.studentmakers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tritern.studentmakers.entity.SchoolComments;

public interface SchoolCommentsRepository extends CrudRepository<SchoolComments, Long> {

	@Query(value = "SELECT * FROM schoolcomments WHERE ids=?1", nativeQuery = true)
	List<SchoolComments> findAllByid(int id);

}
