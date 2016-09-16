package com.map.sort.key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapSortByKey {

	private static class StudentVO {
		private String name;
		private int id;

		StudentVO(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public int getId() {
			return id;
		}

		@Override
		public int hashCode() {
			return this.id;
		}

		public boolean equals(Object o) {
			boolean flag = false;
			StudentVO vo = (StudentVO) o;

			if (vo.id == this.id && vo.name == this.name) {
				flag = true;
			}

			return flag;
		}

		@Override
		public String toString() {
			StringBuffer bf = new StringBuffer();
			bf.append("Student with Id ").append(this.id).append(", having name ").append(this.name);
			return bf.toString();
		}

	}

	private static class SortStudentByName implements Comparator<StudentVO> {

		@Override
		public int compare(StudentVO o1, StudentVO o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}

	}

	private static void sortListOfStudents() {
		List<MapSortByKey.StudentVO> list = new ArrayList<MapSortByKey.StudentVO>();

		list.add(new MapSortByKey.StudentVO(121, "Mehul"));
		list.add(new MapSortByKey.StudentVO(124, "Kunal"));
		list.add(new MapSortByKey.StudentVO(123, "Dhanraj"));
		list.add(new MapSortByKey.StudentVO(125, "Swapnil"));
		list.add(new MapSortByKey.StudentVO(126, "Girish"));

		MapSortByKey.SortStudentByName c = new MapSortByKey.SortStudentByName();
		list.sort(c);

		for (Iterator<MapSortByKey.StudentVO> itr = list.iterator(); itr.hasNext();) {
			System.out.println(itr.next());
		}
	}

	private static void sortKeyOfStudentMap() {
		
		MapSortByKey.SortStudentByName c = new MapSortByKey.SortStudentByName();
		Map<MapSortByKey.StudentVO, Integer> map = new TreeMap<MapSortByKey.StudentVO, Integer>(c);
		
		map.put(new MapSortByKey.StudentVO(121, "Mehul"), 121);	
		map.put(new MapSortByKey.StudentVO(124, "Kunal"),124);		
		map.put(new MapSortByKey.StudentVO(123, "Dhanraj"),123);
		map.put(new MapSortByKey.StudentVO(125, "Swapnil"),125);
		map.put(new MapSortByKey.StudentVO(126, "Girish"),126);

		Set<Map.Entry<MapSortByKey.StudentVO, Integer>> set = map.entrySet();
		
		for(Iterator<Map.Entry<MapSortByKey.StudentVO, Integer>> itr = set.iterator(); itr.hasNext();){
			Map.Entry<MapSortByKey.StudentVO, Integer> e = itr.next();
			System.out.println("Key ["+e.getKey()+"], value "+e.getValue());
		}
	}

	private static void sortValueOfStudentMap01(){
		Map<Integer,MapSortByKey.StudentVO> map = new HashMap<Integer,MapSortByKey.StudentVO>();
		
		map.put(121,new MapSortByKey.StudentVO(121, "Zakir"));	
		map.put(124,new MapSortByKey.StudentVO(124, "Xevier"));		
		map.put(123,new MapSortByKey.StudentVO(123, "Ninaad"));
		map.put(125,new MapSortByKey.StudentVO(125, "Rony"));
		map.put(126,new MapSortByKey.StudentVO(126, "Amrish"));
		
		List<Map.Entry<Integer, MapSortByKey.StudentVO>> list = new ArrayList<Map.Entry<Integer, MapSortByKey.StudentVO>>(map.entrySet());
		
		
		Collections.sort(list, new Comparator<Map.Entry<Integer,MapSortByKey.StudentVO>>() {

			@Override
			public int compare(Entry<Integer, StudentVO> o1, Entry<Integer, StudentVO> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().getName().compareTo(o2.getValue().getName());
			}
			
		});
		
		Map<Integer,MapSortByKey.StudentVO> resultMap = new LinkedHashMap<Integer,MapSortByKey.StudentVO>();
		
		for(Map.Entry<Integer,MapSortByKey.StudentVO> entry : list){
			resultMap.put(entry.getKey(), entry.getValue());
		}
		
		Set<Map.Entry<Integer,MapSortByKey.StudentVO>> set = resultMap.entrySet();
		
		for(Iterator<Map.Entry<Integer,MapSortByKey.StudentVO>> itr = set.iterator(); itr.hasNext();){
			Map.Entry<Integer,MapSortByKey.StudentVO> e = itr.next();
			System.out.println("Key ["+e.getKey()+"], value ["+e.getValue()+"]");
		}
	}
	

	public static void main(String[] args) {
		//sortListOfStudents();
		//sortKeyOfStudentMap();
		
		sortValueOfStudentMap01();
	}
}
