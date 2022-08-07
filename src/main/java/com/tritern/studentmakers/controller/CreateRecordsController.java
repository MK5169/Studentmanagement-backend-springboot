package com.tritern.studentmakers.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tritern.studentmakers.entity.College;
import com.tritern.studentmakers.entity.Comments;
import com.tritern.studentmakers.entity.FinalData;
import com.tritern.studentmakers.entity.Image;
import com.tritern.studentmakers.entity.ProcessedData;
import com.tritern.studentmakers.entity.RequestData;
import com.tritern.studentmakers.entity.School;
import com.tritern.studentmakers.repository.ImageRepository;
import com.tritern.studentmakers.service.CreateRecordService;

@RestController
@RequestMapping("/studentmakers")
public class CreateRecordsController {

	@Autowired
	CreateRecordService service;

	@Autowired
	ImageRepository imageRepository;

	@GetMapping("/schools")
	private ResponseEntity<List<FinalData>> getAllSchool() {
		try {
			List<FinalData> body = service.getAllSchool();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@GetMapping("/school/{Id}")
	private ResponseEntity<FinalData> getSchool(@PathVariable("Id") Long id) {
		try {
			FinalData body = service.getParticularSchool(id);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@PutMapping("/updateschool/{id}")
	private ResponseEntity<String> updateSchool(@PathVariable("id") Long id, @RequestBody School school) {
		try {
			String body = service.updateSchool(id, school);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@GetMapping("/colleges")
	private ResponseEntity<List<FinalData>> getAllCollege() {
		try {
			List<FinalData> body = service.getAllCollege();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@GetMapping("/college/{Id}")
	private ResponseEntity<FinalData> getCollege(@PathVariable("Id") Long id) {
		try {
			FinalData body = service.getParticularCollege(id);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@PutMapping("/updatecollege/{id}")
	private ResponseEntity<String> updateCollege(@PathVariable("id") Long id, @RequestBody College college) {
		try {
			String body = service.updateCollege(id, college);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@PostMapping(value = "/createschool/{data}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> createSchool(@PathVariable("data") String choice, @RequestBody School school) {
		try {
			String body = service.saveSchool(choice, school);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@PostMapping(value = "/image")
	private ResponseEntity<String> images(@RequestBody Image image) throws IOException {
		try {
			String body = service.upload(image.getName(), image.getImagename(), image.getImage());
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@PostMapping(value = "/createcollege/{data}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> createCollege(@PathVariable("data") String choice, @RequestBody College college) {
		try {
			String body = service.saveCollege(choice, college);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@DeleteMapping(value = "/delete/school/{id}")
	private ResponseEntity<String> deleteByIdSchool(@PathVariable("id") Long id) {
		try {
			String body = service.deleteByIdSchool(id);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@DeleteMapping(value = "/delete/college/{id}")
	private ResponseEntity<String> deleteByIdCollege(@PathVariable("id") Long id) {
		try {
			String body = service.deleteByIdCollege(id);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@GetMapping("/get/{choice}/{pageno}")
	private ResponseEntity<List<FinalData>> getdata(@PathVariable("choice") String choice,
			@PathVariable("pageno") int pageno) {
		try {
			if (choice.equals("college")) {
				List<FinalData> body = service.getCollege(pageno);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			} else {
				List<FinalData> body = service.getSchool(pageno);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@GetMapping("/total/{choice}")
	private ResponseEntity<Long> getTotal(@PathVariable("choice") String choice) {
		try {
			if (choice.equals("college")) {
				long body = service.getTotalRecordCollege();
				return ResponseEntity.status(HttpStatus.OK).body(body);
			} else {
				long body = service.getTotalRecordSchool();
				return ResponseEntity.status(HttpStatus.OK).body(body);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body(0L);
		}
	}

	@GetMapping("/search/{choice}/{data}/{pageno}")
	private ResponseEntity<List<FinalData>> getSearchData(@PathVariable("data") String searchData,
			@PathVariable("pageno") int pageno, @PathVariable("choice") String choice) {
		try {
			if (choice.equals("college")) {
				List<FinalData> body = service.getSearchDataCollege(searchData, pageno);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			} else {
				List<FinalData> body = service.getSearchDataSchool(searchData, pageno);
				return ResponseEntity.status(HttpStatus.OK).body(body);

			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@GetMapping("/search/{choice}/{searchData}")
	private ResponseEntity<Integer> getSearchCount(@PathVariable("searchData") String searchData,
			@PathVariable("choice") String choice) {
		try {
			if (choice.equals("college")) {
				int body = service.getSearchCollegeCount(searchData);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			} else {
				int body = service.getSearchSchoolCount(searchData);
				return ResponseEntity.status(HttpStatus.OK).body(body);

			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body(0);
		}
	}

	@GetMapping("/filter/total/{state}/{city}/{syllabus}/{amenities}/{type}/{admissionFor}")
	private ResponseEntity<Integer> getFilterCountSchool(@PathVariable("state") String state,
			@PathVariable("city") String city, @PathVariable("syllabus") String syllabus,
			@PathVariable("amenities") String amenities, @PathVariable("type") String type,
			@PathVariable("admissionFor") String admissionFor) {
		try {
			int body = service.getSchoolCount(state, city, syllabus, amenities, type,admissionFor);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body(0);
		}
	}

	@GetMapping("/filter/school/{pageno}/{state}/{city}/{rating}/{syllabus}/{amenities}/{type}")
	private ResponseEntity<List<FinalData>> getFilterSchoolData(@PathVariable("state") String state,
			@PathVariable("city") String city, @PathVariable("rating") String rating,
			@PathVariable("syllabus") String syllabus, @PathVariable("amenities") String amenities,
			@PathVariable("type") String type, @PathVariable("pageno") int pageno) {
		try {
			List<FinalData> body = service.getFilterSchool(pageno, state, city, rating, syllabus, amenities, type);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	@GetMapping("/filter/college/{pageno}/{state}/{city}/{lowvalue}/{highvalue}/{stream}/{substream}/{programType}/{typeofcollege}")
	private ResponseEntity<List<FinalData>> getFilterCollegeData(@PathVariable("pageno") int pageno,
			@PathVariable("lowvalue") int lowvalue, @PathVariable("highvalue") int highvalue,
			@PathVariable("state") String state, @PathVariable("city") String city,
			@PathVariable("stream") String stream, @PathVariable("substream") String substream,
			@PathVariable("programType") String programtype, @PathVariable("typeofcollege") String typesofCollege) {
		try {
			System.out.println("njsdnfksjdfk");
			List<FinalData> body = service.getFilterCollege(pageno, state, city, stream, substream,
					lowvalue, highvalue, programtype, typesofCollege);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@GetMapping("/total/{state}/{city}/{stream}/{substream}/{programType}/{typeofcollege}")
	private ResponseEntity<Integer> getFilterCountCollege(@PathVariable("state") String state,
			@PathVariable("city") String city, @PathVariable("stream") String stream,
			@PathVariable("substream") String substream, @PathVariable("programType") String programtype,
			@PathVariable("typeofcollege") String typesofCollege) {
		try {
			int body = service.getCollegeCount(state, city, stream, substream, programtype, typesofCollege);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body(0);
		}
	}

	@PostMapping("/requestdata")
	private ResponseEntity<String> createRequestingData(@RequestBody RequestData requestData) {
		try {
			String body = service.createRequestData(requestData);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@GetMapping("/get/requestdata")
	private ResponseEntity<List<RequestData>> getRequestedData() {
		try {
			List<RequestData> body = service.getAllRequestData();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@GetMapping("/get/processedrequest")
	private ResponseEntity<List<ProcessedData>> getProcessedData() {
		try {
			List<ProcessedData> body = service.getAllProcessedData();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return null;
		}
	}

	@PutMapping("ok")
	private ResponseEntity<String> updateRequestedRecord(@RequestBody RequestData requestData) {
		try {
			String body = service.updateRequestedRecord(requestData);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).body("Something went wrong");
		}
	}

	@GetMapping("get/homepage/college")
	private ResponseEntity<List<FinalData>> gethomePageCollege() {
		try {
			List<FinalData> body = service.getHomePageCollegeData();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@GetMapping("get/homepage/school")
	private ResponseEntity<List<FinalData>> gethomePageSchool() {
		try {
			List<FinalData> body = service.getHomePageSchoolData();
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@GetMapping("excel")
	private String excelData() {
		return service.excelDatas();
	}

	@GetMapping("get/admin/college")
	private ResponseEntity<List<FinalData>> adminCollegePagination(
			@RequestParam(name = "pageno", required = false) int pageno) {
		try {
			List<FinalData> finalData = service.getAdminCollege(pageno);
			return ResponseEntity.status(HttpStatus.OK).body(finalData);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("get/admin/school")
	private ResponseEntity<List<FinalData>> adminSchoolPagination(
			@RequestParam(required = false, value = "pageno") int pageno) {
		try {
			List<FinalData> finalData = service.getAdminSchool(pageno);
			return ResponseEntity.status(HttpStatus.OK).body(finalData);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/comments/{choice}")
	private ResponseEntity<String> createComments(@RequestBody Comments comment,
			@PathVariable("choice") String choice) {
		try {
			if (choice.equals("school")) {
				String body = service.createSchoolComments(comment);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			} else {
				String body = service.createCollegeComments(comment);
				return ResponseEntity.status(HttpStatus.OK).body(body);
			}
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/get/comments")
	private ResponseEntity<Comments> getComments(@RequestParam(name = "id", required = false) int id) {
		try {
			service.getCommentsData(id);
			return null;
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
