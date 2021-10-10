//package com.tritern.demo1.studentconfiguration;
//
//
//import com.tritern.demo1.studententity.Student;
//import com.tritern.demo1.studentrepository.StudentRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfiguration {
//
//    @Bean
//    CommandLineRunner commandLineRunner(
//            StudentRepository repository) {
//        return args -> {
//            Student mani = new Student(
//                    "mani",
//                    "mmanikandan609@gmial.com",
//                    LocalDate.of(1999, Month.NOVEMBER, 11)
//            );
//
//            Student vicky = new Student(
//                    "vicky",
//                    "vicky@gmial.com",
//                    LocalDate.of(1994, Month.SEPTEMBER, 12)
//            );
//
//            repository.saveAll(
//                    List.of(mani, vicky)
//            );
//        };
//    }
//}
