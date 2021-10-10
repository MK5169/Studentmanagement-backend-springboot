package com.tritern.demo1.studentservice;

import com.tritern.demo1.studententity.Student;
import com.tritern.demo1.studentrepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
         Optional<Student> studentOptional=
                studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email is already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student Id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

//    @Transactional
    public void updateStudent(
            Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId);
//        Student student = studentRepository.findById(studentId);
//                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));
Student stud = new Student();
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email is already taken");
            }
            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}
// STOPSHIP: 04-08-2021  