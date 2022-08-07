package com.tritern.studentmakers.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tritern.studentmakers.entity.School;

public interface SchoolRepository extends PagingAndSortingRepository<School, Integer> {
	@Query("FROM School WHERE id = ?1")
	School findById(Long id);

	// To get search data
	@Query(value = "SELECT * FROM school s WHERE s.details LIKE %:search% OR s.address LIKE %:search%", nativeQuery = true)
	Page<School> findbyname(@Param("search") String searchData, Pageable paging);

	// To get filter data
	@Query(value = "SELECT * FROM school s WHERE  s.details LIKE %:state% OR s.address LIKE %:state% OR s.details LIKE %:city% OR s.address LIKE %:city% OR s.details LIKE %:syllabus% OR s.details LIKE %:amenities% OR s.details LIKE %:type% OR s.details LIKE %:admissionFor%", nativeQuery = true)
	Page<School> findbyBasedOnData(@Param("state") String state, @Param("city") String city,
			@Param("syllabus") String syllabus, @Param("amenities") String amenities, @Param("type") String type,
			@Param("admissionFor") String admissionFor, Pageable paging);

	// To get search page total count
	@Query(value = "SELECT * FROM school s WHERE s.details LIKE %:search% OR s.address LIKE %:search%", nativeQuery = true)
	List<School> findbysearch(@Param("search") String searchData);

	// To get filter page total count
	@Query(value = "SELECT * FROM school s WHERE  s.details LIKE %:state% OR s.address LIKE %:state% OR s.details LIKE %:city% OR s.address LIKE %:city% OR s.details LIKE %:syllabus% OR s.details LIKE %:amenities% OR s.details LIKE %:type% OR s.details LIKE %:admissionFor%", nativeQuery = true)
	List<School> findbyDetails(@Param("state") String state, @Param("city") String city,
			@Param("syllabus") String syllabus, @Param("amenities") String amenities, @Param("type") String type,
			@Param("admissionFor") String admissionFor);

}
