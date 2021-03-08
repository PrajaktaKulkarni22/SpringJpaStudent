package com.jpapractice.Springjpapractice.controller;

import com.jpapractice.Springjpapractice.model.Student;
import com.jpapractice.Springjpapractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    protected StudentRepository studentRepository;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student saved successfully";
    }

    @GetMapping("/displayStudent")
    public List<Student> displayStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/displayStudentById/{id}")
    public Optional<Student> getStudentByid(@PathVariable Integer id){
        return studentRepository.findById(id);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){
        Optional<Student> stud=studentRepository
                .findById(student.getId());

        stud.get().setFirstname(student.getFirstname());
        stud.get().setLastname(student.getLastname());
        stud.get().setCity(student.getCity());

        studentRepository.save(stud.get());
        return "Student updated successfully";
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    @GetMapping("/displayByFirstnameAndLastname/{firstname}/{lastname}")
    public List<Student> displayByFirstnameAndLastname(@PathVariable String firstname,
                                                       @PathVariable String lastname){
       return studentRepository.findByFirstnameAndLastname(firstname,lastname);
    }

    @GetMapping("/displayDistinctFirstnameLastname/{firstname}/{lastname}")
    public List<Student> displayDistinctByFirstnameAndLastname(@PathVariable String firstname,@PathVariable String lastname){
        return studentRepository.findDistinctByFirstnameAndLastname(firstname,lastname);
    }

    @GetMapping("/displayByFirstnameOrLastname/{firstname}/{lastname}")
    public List<Student> displayByFirstnameOrLastname(@PathVariable String firstname,@PathVariable String lastname){
        return studentRepository.findByFirstnameOrLastname(firstname, lastname);
    }

    @GetMapping("/displayAgeLessThan/{age}")
    public List<Student> displayByAgeLessThan(@PathVariable Integer age){
        return studentRepository.findByAgeLessThan(age);
    }

    @GetMapping("/displayAgeGreaterThan/{age}")
    public List<Student> displayByAgeGreaterThan(@PathVariable Integer age){
        return studentRepository.findByAgeGreaterThan(age);
    }

    @GetMapping("/displayFirstnameStartingWith/{firstname}")
    public List<Student> displayFirstnameStartingWith(@PathVariable String firstname){
        return studentRepository.findByFirstnameStartingWith(firstname);
    }

    @GetMapping("/displayLastnameEndingWith/{lastname}")
    public List<Student> displayLastnameEndingWith(@PathVariable String lastname){
        return studentRepository.findByLastnameEndingWith(lastname);
    }

    @GetMapping("/displayFirstnameContaining/{firstname}")
    public List<Student> displayFirstnameContaining(@PathVariable String firstname){
        return studentRepository.findByFirstnameContaining(firstname);
    }

    @GetMapping("/displayOrderByAge/{firstname}")
    public List<Student> displayOrderByAge(@PathVariable String firstname){
        return studentRepository.findByFirstnameOrderByAge(firstname);
    }

    @GetMapping("/findbyin")
    public List<Student> displayIdIn(@RequestParam List<Integer> id){
        return studentRepository.findByIdIn(id);
    }
}
