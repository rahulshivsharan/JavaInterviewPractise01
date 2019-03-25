package com.map.sort.ex01;

public class StudentVO {
	private Integer id;
	private String name;
	
	public StudentVO (Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int code = 31 * this.id.hashCode();
		return code;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean flag = false;
		StudentVO vo = null;
		
		if(o != null && o instanceof StudentVO) {
			vo = (StudentVO) o;
			
			if(vo.getId() == this.getId()) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	@Override
	public String toString() {
		StringBuffer strb = new StringBuffer();
		strb.append("ID : ").append(this.id).append(", NAME : ").append(this.name);
		return strb.toString();
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
