package com.immutable.ex01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public final class Employee implements Cloneable, Externalizable{
	private final Integer age;
	private final String name;
	private final List<String> companies;
	private final Date dob;
	
	public Employee() {
		this.age = null;
		this.name = null;
		this.companies = null;
		this.dob = null;
	}

	public Employee(Integer age, String name,List<String> companies, Date dob) {
		this.age = age;
		this.name = name;
		this.companies = new ArrayList<String>(companies);
		this.dob = dob;
	}

	public Integer getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public Date getDob() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.dob);
		return cal.getTime();
	}

	public List<String> getCompanies() {
		List<String> clone = new ArrayList<String>(this.companies.size());
		clone.addAll(this.companies);		
		return clone;
	}
	
	@Override
	public String toString() {
		StringJoiner join = new StringJoiner(", ");
		join.add("NAME "+this.name)
			.add("AGE "+this.age)
			.add("DOB "+this.dob)
			.add("COMPANIES WORKED IN "+String.join(", ", this.companies));
		return join.toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Cannot be cloned");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		throw new IOException("This operation is not supported");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException {
		throw new IOException("This operation is not supported");
	}
	
	private String getDateString() {
		String date = null;
		DateFormat df = null;
		try {
			df = new SimpleDateFormat("dd MMM yyyy");
			date = df.format(this.dob);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
