package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Employee;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/upload-excel", method = RequestMethod.POST)
	public ResponseEntity<List<Employee>> readXlData(@RequestParam("file") MultipartFile file) throws IOException {

		return new ResponseEntity<List<Employee>>(demoService.readExcel(file.getInputStream()), HttpStatus.OK);

	}

}
