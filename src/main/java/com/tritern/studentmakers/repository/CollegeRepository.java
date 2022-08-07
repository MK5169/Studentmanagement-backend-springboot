package com.tritern.studentmakers.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tritern.studentmakers.entity.College;

public interface CollegeRepository extends PagingAndSortingRepository<College, Integer> {
	@Query("FROM College WHERE id = ?1")
	College findById(Long id);

	@Query(value = "SELECT * FROM college c WHERE c.details LIKE %:search%", nativeQuery = true)
	Page<College> findbyname(@Param("search") String searchData, Pageable paging);

	@Query(value = "SELECT * FROM college c WHERE c.details LIKE %:state% OR c.details LIKE %:city% OR c.details LIKE %:stream% OR c.details LIKE %:substream% OR c.details LIKE %:programtype% OR c.details LIKE %:typeofcollege%", nativeQuery = true)
	List<College> findbyName(@Param("state") String state, @Param("city") String city, @Param("stream") String stream,
			@Param("substream") String substream, @Param("programtype") String programtype,
			@Param("typeofcollege") String typesofCollege);

//	@Query(value = "SELECT * FROM college c WHERE c.details LIKE %:state% OR c.details BETWEEN %:lowvalue% AND %:highvalue% OR c.details LIKE %:city% OR c.details LIKE %:stream% OR c.details LIKE %:substream% OR c.details LIKE %:programtype% OR c.details LIKE %:typeofcollege%", nativeQuery = true)
	@Query(value = "SELECT * FROM college c WHERE c.details BETWEEN 10000 AND 15000 LIMIT 9", nativeQuery = true)
	Page<College> findbyBasedOnData(Pageable paging);
//	Page<College> findbyBasedOnData(@Param("state") String state, @Param("city") String city,
//			@Param("lowvalue") String lowvalue, @Param("highvalue") String highvalue,
//			@Param("stream") String stream,
//			@Param("substream") String substream, @Param("programtype") String programtype,
//			@Param("typeofcollege") String typesofCollege, Pageable paging);
//					

	@Query(value = "SELECT * FROM college c WHERE c.details LIKE %:search%", nativeQuery = true)
	List<College> findbysearch(@Param("search") String searchData);

}