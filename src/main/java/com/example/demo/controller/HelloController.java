package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private List<String> employee = new ArrayList<>();

    @GetMapping("getHello")
    public String sayHello(){
        return "Hello how are you";
    }

    @PostMapping("submit")
    public String addEmployee( @RequestBody  String employeeName){
        String [] arguments = employeeName.split("=");
        employee.add(arguments[1]);
        return "Employee Sucessfully Added";
    }

    @GetMapping("getEmployee")
    public List<String> getEmployee(){
        return employee;
    }

    @PostMapping("/bulk-upload")
    public String bulkUpload(
            @RequestPart(value = "file", required = false) MultipartFile multipartFile) throws Exception{
        InputStream inputStream = multipartFile.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        br.lines().forEach(l -> employee.add(l));
        return "All record uploaded";
    }


}
