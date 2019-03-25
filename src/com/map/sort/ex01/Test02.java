package com.map.sort.ex01;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test02 {

	/*
	 * Sort Map by key.
	 * Default sorting is by key
	 */
	private static void sortMap() {
		Map<Integer, StudentVO> map = new TreeMap<Integer, StudentVO>(new Comparator<Integer>() {
			
			public int compare(Integer i, Integer j) {
				return i.compareTo(j);
			}
		});
		
		map.put(123, new StudentVO(123, "Mushtaq Mallik"));
		map.put(124, new StudentVO(124, "Aslam Wahab"));
		map.put(114, new StudentVO(114, "Nazim Ahmed"));
		map.put(118, new StudentVO(118, "Qasim Bakhtiar"));
		map.put(103, new StudentVO(103, "Karim Rehman"));
		
		Set<Map.Entry<Integer, StudentVO>> entrySet = map.entrySet();
		
		for(Map.Entry<Integer, StudentVO> entry : entrySet) {
			System.out.println("["+entry.getKey()+"], "+entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		sortMap();
	}

}
