package com.tritern.studentmakers.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poiji.bind.Poiji;
import com.tritern.studentmakers.entity.College;
import com.tritern.studentmakers.entity.CollegeComments;
import com.tritern.studentmakers.entity.Comments;
import com.tritern.studentmakers.entity.DetailsData;
import com.tritern.studentmakers.entity.ExcelData;
import com.tritern.studentmakers.entity.FinalData;
import com.tritern.studentmakers.entity.Image;
import com.tritern.studentmakers.entity.ProcessedData;
import com.tritern.studentmakers.entity.RequestData;
import com.tritern.studentmakers.entity.ReviewRating;
import com.tritern.studentmakers.entity.School;
import com.tritern.studentmakers.entity.SchoolComments;
import com.tritern.studentmakers.repository.CollegeCommentsRepository;
import com.tritern.studentmakers.repository.CollegeRepository;
import com.tritern.studentmakers.repository.ImageRepository;
import com.tritern.studentmakers.repository.ProcessedDataRepository;
import com.tritern.studentmakers.repository.RequestDataRepository;
import com.tritern.studentmakers.repository.SchoolCommentsRepository;
import com.tritern.studentmakers.repository.SchoolRepository;

@Service
public class CreateRecordService {

	@Autowired
	SchoolRepository schoolRepo;

	@Autowired
	CollegeRepository collegeRepo;

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	RequestDataRepository requestDataRepository;

	@Autowired
	ProcessedDataRepository processedDataRepository;

	@Autowired
	SchoolCommentsRepository schoolCommentsRepository;

	@Autowired
	CollegeCommentsRepository collegeCommentsRepository;

	public List<FinalData> getProcessedSchool(List<School> schools) {
		List<FinalData> allData = new ArrayList<FinalData>();
		for (School school : schools) {
			List<FinalData> temp = new ArrayList<FinalData>();
			Gson gson = new GsonBuilder().create();
			DetailsData detailsData = gson.fromJson(school.getDetails(), DetailsData.class);
			FinalData details = new FinalData();
			String id = Long.toString(school.getId());
			details.setId(id);
			details.setCollegeRank(detailsData.getCollegeRank());
			details.setAddress(school.getAddress());
			details.setSchoolType(detailsData.getSchoolType());
			details.setAminities(detailsData.getAminities());
			details.setDesc(school.getDescription());
			details.setName(detailsData.getName());
			details.setFeeStructure(detailsData.getFeeStructure());
			details.setFaculty(detailsData.getFaculty());
			details.setReview(detailsData.getReview());
			Image image = imageRepository.findbyimage(id, "school");
			if (image == null) {
				List<String> tempr = Collections.<String>emptyList();
				details.setImage(tempr);
			} else {
				details.setImage(image.getImage());
			}
			temp.add(details);
			allData.addAll(temp);
		}
		return allData;
	}

	public List<FinalData> getProcessedCollege(List<College> colleges) {
		List<FinalData> allData = new ArrayList<FinalData>();
		for (College college : colleges) {
			List<FinalData> temp = new ArrayList<FinalData>();
			Gson gson = new GsonBuilder().create();
			DetailsData detailsData = gson.fromJson(college.getDetails(), DetailsData.class);
			FinalData details = new FinalData();
			String id = Long.toString(college.getId());
			details.setId(id);
			details.setCollegeRank(detailsData.getCollegeRank());
			details.setAddress(college.getAddress());
			details.setSchoolType(detailsData.getSchoolType());
			details.setAminities(detailsData.getAminities());
			details.setDesc(college.getDescription());
			details.setName(detailsData.getName());
			details.setFeeStructure(detailsData.getFeeStructure());
			details.setFaculty(detailsData.getFaculty());
			details.setReview(detailsData.getReview());
			Image image = imageRepository.findbyimage(id, "college");
			if (image == null) {
				List<String> tempr = Collections.<String>emptyList();
				details.setImage(tempr);
			} else {
				details.setImage(image.getImage());
			}
			temp.add(details);
			allData.addAll(temp);
		}
		return allData;
	}

	public List<FinalData> getAllSchool() {
		try {
			List<School> schools = new ArrayList<School>();
			schoolRepo.findAll().forEach(users -> schools.add(users));
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getAllCollege() {
		try {
			List<College> colleges = new ArrayList<College>();
			collegeRepo.findAll().forEach(users -> colleges.add(users));
			return getProcessedCollege(colleges);
		} catch (Exception e) {
			throw e;
		}
	}

	public FinalData getParticularSchool(Long id) {
		try {
			if (id == null) {
				return null;
			} else {
				System.out.println(id);
				School school = schoolRepo.findById(id);
				System.out.println(school);
				Gson gson = new GsonBuilder().create();
				DetailsData detailsData = gson.fromJson(school.getDetails(), DetailsData.class);
				FinalData finalData = new FinalData();
				String ids = Long.toString(school.getId());
				finalData.setId(ids);
				finalData.setCollegeRank(detailsData.getCollegeRank());
				finalData.setAddress(school.getAddress());
				finalData.setSchoolType(detailsData.getSchoolType());
				finalData.setAminities(detailsData.getAminities());
				finalData.setDesc(school.getDescription());
				finalData.setName(detailsData.getName());
				finalData.setFeeStructure(detailsData.getFeeStructure());
				finalData.setFaculty(detailsData.getFaculty());
				finalData.setReview(detailsData.getReview());
				Image image = imageRepository.findbyimage(ids, "school");
				if (image == null) {
					List<String> tempr = Collections.<String>emptyList();
					finalData.setImage(tempr);
				} else {
					finalData.setImage(image.getImage());
				}
				return finalData;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public FinalData getParticularCollege(Long id) {
		try {
			if (id == null) {
				return null;
			} else {
				College college = collegeRepo.findById(id);
				Gson gson = new GsonBuilder().create();
				DetailsData detailsData = gson.fromJson(college.getDetails(), DetailsData.class);
				FinalData finalData = new FinalData();
				String ids = Long.toString(college.getId());
				finalData.setId(ids);
				finalData.setCollegeRank(detailsData.getCollegeRank());
				finalData.setAddress(college.getAddress());
				finalData.setSchoolType(detailsData.getSchoolType());
				finalData.setAminities(detailsData.getAminities());
				finalData.setDesc(college.getDescription());
				finalData.setName(detailsData.getName());
				finalData.setFeeStructure(detailsData.getFeeStructure());
				finalData.setFaculty(detailsData.getFaculty());
				finalData.setReview(detailsData.getReview());
				Image image = imageRepository.findbyimage(ids, "college");
				if (image == null) {
					List<String> tempr = Collections.<String>emptyList();
					finalData.setImage(tempr);
				} else {
					finalData.setImage(image.getImage());
				}
				return finalData;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String saveSchool(String choice, School school) {
		try {
			if (schoolRepo.findById(school.getId()) == null) {
				schoolRepo.save(school);
				return "Saved in school";
			} else {
				return "Id already exist";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String saveCollege(String choice, College college) {
		try {
			if (collegeRepo.findById(college.getId()) == null) {
				collegeRepo.save(college);
				return "Saved in college";
			} else {
				return "Id already exist";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateSchool(Long id, School school) {
		try {
			if (id == null || schoolRepo.findById(id) == null) {
				return " Id doesn't exist";
			} else {
				School schoolEdit = schoolRepo.findById(id);
				schoolEdit.setDetails(school.getDetails());
				schoolEdit.setAddress(school.getAddress());
				schoolEdit.setDescription(school.getDescription());
				schoolRepo.save(schoolEdit);
				return "updated successfull";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateCollege(Long id, College college) {
		try {
			if (id == null || collegeRepo.findById(id) == null) {
				return " Id doesn't exist";
			} else {
				College collegeEdit = collegeRepo.findById(id);
				collegeEdit.setDetails(college.getDetails());
				collegeEdit.setAddress(college.getAddress());
				collegeEdit.setDescription(college.getDescription());
				collegeRepo.save(college);
				return "updated successfull";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String upload(String id, String imagename, List<String> files) throws IOException {
		try {
			Image temp = imageRepository.findbyimage(id, imagename);
			if (temp != null) {
				List<String> file = temp.getImage();
				file.addAll(files);
				temp.setImage(file);
				imageRepository.save(temp);
				return "added successfully";
			} else {
				Image image = new Image();
				image.setName(id);
				image.setImagename(imagename);
				image.setImage(files);
				imageRepository.save(image);
				return "added successfully";
			}
		} catch (Exception e) {
			return "image not added" + e.getMessage() + e.getStackTrace();
		}
	}

	public String deleteByIdSchool(Long id) {
		School school;
		try {
			if (id == null || schoolRepo.findById(id) == null) {
				return " Id doesn't exist";
			} else {
				school = schoolRepo.findById(id);
				schoolRepo.delete(school);
				return "deleted successfull";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String deleteByIdCollege(Long id) {
		College college;
		try {
			if (id == null || collegeRepo.findById(id) == null) {
				return " Id doesn't exist";
			} else {
				college = collegeRepo.findById(id);
				collegeRepo.delete(college);
				return "deleted successfull";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getCollege(int pageNo) {
		try {
			Pageable paging = PageRequest.of(pageNo - 1, 9);
			Page<College> pagedResult = collegeRepo.findAll(paging);
			List<College> collegeList = pagedResult.toList();
			return getProcessedCollege(collegeList);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getSchool(int pageNo) {
		try {
			Pageable paging = PageRequest.of(pageNo - 1, 9);
			Page<School> pagedResult = schoolRepo.findAll(paging);
			List<School> schools = pagedResult.toList();
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public long getTotalRecordSchool() {
		return schoolRepo.count();
	}

	public long getTotalRecordCollege() {
		return collegeRepo.count();
	}

	public int getSearchSchoolCount(String searchData) {
		List<School> school = schoolRepo.findbysearch(searchData);
		int count = school.size();
		System.out.println("school list count : " + count);
		return count;
	}

	public int getSearchCollegeCount(String searchData) {
		List<College> college = collegeRepo.findbysearch(searchData);
		int count = college.size();
		System.out.println("college list count : " + count);
		return count;
	}

	public int getSchoolCount(String state, String city, String syllabus, String amenities, String type,
			String admissionFor) {
		List<School> school = schoolRepo.findbyDetails(state, city, syllabus, amenities, type,admissionFor);
		int count = school.size();
		System.out.println("school list filter count : " + count);
		return count;
	}

	public int getCollegeCount(String state, String city, String stream, String substream, String programtype,
			String typesofCollege) {

		List<College> college = collegeRepo.findbyName(state, city, stream, substream, programtype, typesofCollege);
		int count = college.size();
		System.out.println("college list filter count : " + count);
		return count;
	}

	public List<FinalData> getFilterCollege(int pageno, String state, String city, String stream, String substream,
			int lowvalue, int highvalue, String programtype, String typeofcollege) {
		try {
			System.out.println("dfdsfsdfsdfsd");
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<College> college = collegeRepo.findbyBasedOnData(paging);
			List<College> colleges = college.toList();
			return getProcessedCollege(colleges);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getFilterSchool(int pageno, String state, String city, String rating, String syllabus,
			String amenities, String type) {
		try {
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<School> school = schoolRepo.findbyBasedOnData(state, city, rating, syllabus, amenities, type, paging);
			List<School> schools = school.toList();
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getSearchDataSchool(String searchData, int pageno) {
		try {
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<School> school = schoolRepo.findbyname(searchData, paging);
			List<School> schools = school.toList();
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getSearchDataCollege(String searchData, int pageno) {
		try {
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<College> college = collegeRepo.findbyname(searchData, paging);
			List<College> colleges = college.toList();
			return getProcessedCollege(colleges);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getHomePageCollegeData() {
		try {
			Pageable paging = PageRequest.of(0, 4);
			Page<College> college = collegeRepo.findAll(paging);
			List<College> colleges = college.toList();
			return getProcessedCollege(colleges);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getHomePageSchoolData() {
		try {
			Pageable paging = PageRequest.of(0, 4);
			Page<School> school = schoolRepo.findAll(paging);
			List<School> schools = school.toList();
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public String createRequestData(RequestData requestData) {
		try {
			if (requestData != null) {
				requestDataRepository.save(requestData);
				return "request has been sent";
			} else {
				return "Please try again";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<RequestData> getAllRequestData() {
		try {
			List<RequestData> requestData = new ArrayList<RequestData>();
			requestDataRepository.findAll().forEach(temp -> requestData.add(temp));
			return requestData;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<ProcessedData> getAllProcessedData() {
		try {
			List<ProcessedData> processData = new ArrayList<ProcessedData>();
			processedDataRepository.findAll().forEach(temp -> processData.add(temp));
			return processData;
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateRequestedRecord(RequestData requestData) {
		if (requestData != null) {
			requestDataRepository.deleteById(requestData.getId());
			ProcessedData processData = new ProcessedData();
			processData.setCollegename(requestData.getCollegename());
			processData.setEmail(requestData.getEmail());
			processData.setName(requestData.getName());
			processData.setPhonenumber(requestData.getPhonenumber());
			processedDataRepository.save(processData);
			return "updated";
		} else {
			return "try again";
		}
	}

	public String excelDatas() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/School.xlsx");
		List<ExcelData> excelData = Poiji.fromExcel(file, ExcelData.class);
		int number = excelData.size();
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		for (int i = 0; i < number; i++) {
			ExcelData exceldata = new ExcelData();
			exceldata = excelData.get(i);
			DetailsData finalData = new DetailsData();
			finalData.setCollegeRank("");
			finalData.setName(exceldata.getName());
			finalData.setSchoolType(exceldata.getSection());
			finalData.setAminities(exceldata.getAminities());
			finalData.setFeeStructure(Collections.<Object>emptyList());
			finalData.setFaculty(Collections.<Object>emptyList());
			if (exceldata.getRating() == null) {
				finalData.setReview(Collections.<Object>emptyList());
			} else {
				List<Object> review = new ArrayList<>();
				int count = exceldata.getRating().size();
				for (int temp = 0; temp < count; temp++) {
					ReviewRating reviewRating = new ReviewRating();
					reviewRating.setReviewDesc(exceldata.getReview().get(temp));
					reviewRating.setRating(exceldata.getRating().get(temp));
					List<Object> tempList = new ArrayList<Object>();
					tempList.add(reviewRating);
					review.addAll(tempList);
				}
				finalData.setReview(review);
			}
			String student = gson.toJson(finalData, DetailsData.class);
			School school = new School();
			school.setId(Long.parseLong(exceldata.getId()));
			school.setDetails(student);
			school.setAddress(exceldata.getAddress());
			school.setDescription(exceldata.getDesc());
			schoolRepo.save(school);
		}

		return "All objects created";
	}

	public List<FinalData> getAdminCollege(int pageno) {
		try {
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<College> college = collegeRepo.findAll(paging);
			List<College> colleges = college.toList();
			return getProcessedCollege(colleges);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<FinalData> getAdminSchool(int pageno) {
		try {
			Pageable paging = PageRequest.of(pageno - 1, 9);
			Page<School> school = schoolRepo.findAll(paging);
			List<School> schools = school.toList();
			return getProcessedSchool(schools);
		} catch (Exception e) {
			throw e;
		}
	}

	public String createSchoolComments(Comments comment) {
		try {
			if (comment != null) {
				SchoolComments schoolComments = new SchoolComments();
				schoolComments.setIds(comment.getIds());
				schoolComments.setName(comment.getName());
				schoolComments.setComment(comment.getComment());
				System.out.println("dfsfs");
				System.out.println(schoolComments);
				schoolCommentsRepository.save(schoolComments);
				return "created comments in school";
			} else {
				return "Got null. Please try again";
			}
		} catch (Exception exception) {
			throw exception;
		}
	}

	public String createCollegeComments(Comments comment) {
		try {
			if (comment != null) {
				CollegeComments collegeComments = new CollegeComments();
				collegeComments.setIds(comment.getIds());
				collegeComments.setName(comment.getName());
				collegeComments.setComment(comment.getComment());
				collegeCommentsRepository.save(collegeComments);
				return "created comments in College";
			} else {
				return "Got null. Please try again";
			}
		} catch (Exception exception) {
			throw exception;
		}
	}

	public List<Comments> getCommentsData(int id) {
		List<SchoolComments> schoolComment = schoolCommentsRepository.findAllByid(id);
		System.out.println(schoolComment);
		return null;
	}
}
