package com.jpapractice.Springjpapractice.repository;

import com.jpapractice.Springjpapractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByFirstnameAndLastname(String firstname,String lastname);
    List<Student> findDistinctByFirstnameAndLastname(String firstname,String lastname);
    List<Student> findByFirstnameOrLastname(String firstname,String lastname);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByFirstnameStartingWith(String firstname);
    List<Student> findByLastnameEndingWith(String lastname);
    List<Student> findByFirstnameContaining(String firstname);
    List<Student> findByFirstnameOrderByAge(String fistname);
    List<Student> findByIdIn(List<Integer> id);

}
