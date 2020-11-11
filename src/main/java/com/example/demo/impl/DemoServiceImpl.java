package com.example.demo.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Employee;
import com.example.demo.service.DemoService;

@Configuration
public class DemoServiceImpl implements DemoService {

	@Override
	public List<Employee> readExcel(InputStream inputStream) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
			
			for(int i = 0; i<sheetAt.getPhysicalNumberOfRows();i++) {
				if(i>0) {
					XSSFRow row = sheetAt.getRow(i);
					
					Employee employee = new Employee((int) row.getCell(0).getNumericCellValue(), row.getCell(1).getStringCellValue(),
							new Date( row.getCell(2).getStringCellValue()), (Double) row.getCell(3).getNumericCellValue(), (int) row.getCell(4).getNumericCellValue());
					employeeList.add(employee);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

}
