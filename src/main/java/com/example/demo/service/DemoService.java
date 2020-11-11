package com.example.demo.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public interface DemoService {
	
	public List<Employee> readExcel(InputStream inputStream);

}
