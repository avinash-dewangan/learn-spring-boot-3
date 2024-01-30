package com.avidew.learn.student;

import com.avidew.learn.dto.APIBaseResponse;
import com.avidew.learn.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avi")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allResEnt")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/allList")
    public List<Student> getAllStudentList(){
        return studentService.getAllStudent();

    }


    @GetMapping("/allListAPI")
    public APIBaseResponse<?> getAllStudentListAPI(){
        APIBaseResponse<List<Student>> studentAPIBaseResponse = new APIBaseResponse<>();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseCode(200);
        responseDto.setResponseDescription("success");
        responseDto.setMessage("success");
        studentAPIBaseResponse.setResponseDto(responseDto);
        studentAPIBaseResponse.setData(studentService.getAllStudent());
        return studentAPIBaseResponse;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student s){
        return new ResponseEntity<Student>(studentService.addStudent(s),HttpStatus.OK);
    }




}
