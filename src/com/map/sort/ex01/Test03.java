package com.map.sort.ex01;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Test03 {

	/*
	 * Sorting Map on the basis of key, by default is key
	 */
	private static void sortMap() {
		
		Map<Integer, StudentVO> map = new TreeMap<Integer, StudentVO>(new Comparator<Integer>() {
			
			public int compare(Integer i, Integer j) {
				return i.compareTo(j);
			}
		});
		
		map.put(23, new StudentVO(123, "Toney Stark"));
		map.put(11, new StudentVO(124, "Clark Kent"));
		map.put(49, new StudentVO(114, "Steve Rogers"));
		map.put(18, new StudentVO(118, "Billy Batson"));
		map.put(13, new StudentVO(103, "Bruce Wayne"));
		
		Set<Map.Entry<Integer, StudentVO>> entrySet = map.entrySet();
		
		for(Map.Entry<Integer, StudentVO> entry : entrySet) {
			System.out.println("["+entry.getKey()+"], "+entry.getValue());
		}
		
	}
	
	/*
	 * Sorting Map on the basis of value
	 */
	private static void sortMapByValue() {
		Map<Integer, StudentVO> map = new HashMap<Integer,StudentVO>();
		map.put(23, new StudentVO(123, "Toney Stark"));
		map.put(11, new StudentVO(124, "Clark Kent"));
		map.put(49, new StudentVO(114, "Steve Rogers"));
		map.put(18, new StudentVO(118, "Billy Batson"));
		map.put(13, new StudentVO(103, "Bruce Wayne"));
		
		Set<Map.Entry<Integer, StudentVO>> entrySet = map.entrySet();
		
		Set<Map.Entry<Integer, StudentVO>> set = new TreeSet<Map.Entry<Integer, StudentVO>>(new Comparator<Map.Entry<Integer, StudentVO>>() {
			
			@Override
			public int compare(Map.Entry<Integer, StudentVO> e1, Map.Entry<Integer, StudentVO> e2) {
				return e1.getValue().getId().compareTo(e2.getValue().getId());
			}
		});
		
		set.addAll(entrySet);
		
		for(Map.Entry<Integer, StudentVO> entry : set) {
			System.out.println("["+entry.getKey()+"], "+entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		sortMap();
		System.out.println("\n\n\n");
		sortMapByValue();
	}

}
