package com.immutable.ex01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest01 {
	public static void main(String [] args) {
		Employee emp = null;
		List<String> companyList = null;
		Date date = null;
		try {
			companyList = new ArrayList<String>();
			companyList.add("IBM");
			companyList.add("Google");
			companyList.add("Norton");
			companyList.add("Seable");
			companyList.add("Nekki");
			date = toDate("28 Oct 1981");
			emp = new Employee(23, "John Molkovich", companyList, date);
			
			date = emp.getDob();
			
			date = new Date(); 
			
			companyList = emp.getCompanies();
			companyList.add("Toyo Corp");
			System.out.println(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static Date toDate(String dateString) throws Exception{
		Date d = null;
		DateFormat df = new SimpleDateFormat("d MMM yyyy");
		d = df.parse(dateString);
		return d;
	}
}
