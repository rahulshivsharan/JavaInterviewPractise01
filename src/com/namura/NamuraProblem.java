package com.namura;

import java.io.*;
import java.util.*;

class MyFileUtil{
	
	/*
		Read a File content line by line and print
	*/
	public static void readFile(String fileName) throws Exception{
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		do{			
			if(line != null){
				System.out.println(line);
			}

			line = reader.readLine();
		}while(line != null);
	}

	/*
		Copy the numbers present in the file, store in 
		list, sort it and than write into another file.
	*/
	public static void readFileThanWrite(String sourceFileName,String destinationFileName) throws Exception{
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
		List<Integer> list = new ArrayList<Integer>();
		do{			
			if(line != null){				
				list.add(Integer.parseInt(line));
			}

			line = reader.readLine();
		}while(line != null);

		Collections.sort(list);

		File file = new File(destinationFileName);
		FileWriter fileWriter = new FileWriter(file,true); // 'True' means write content to end of file
 		BufferedWriter buff = new BufferedWriter(fileWriter);
		PrintWriter out = new PrintWriter(buff);
		
		for(Iterator<Integer> itr = list.iterator();itr.hasNext();){
			out.println(itr.next());
		}

		out.close();
		buff.close();
		fileWriter.close();
	}

	/*
		Write a content i.e. numbers in an array to a file on every other line 
	*/
	public static void writeFile(String fileName) throws Exception{
		PrintWriter writer = new PrintWriter(fileName,"UTF-8");
		int [] inputArray = new int[]{12,34,56,78,45,4};
		for(int i = 0; i < inputArray.length; i++){
			writer.println(inputArray[i]);			
		}
		writer.close();
	}

	/*
		Writing the content to the end of the file
	*/
	public static void appendData(String data, String fileName) throws Exception{
		File file = new File(fileName);
		FileWriter fileWriter = new FileWriter(file,true); // 'True' means write content to end of file
 		BufferedWriter buff = new BufferedWriter(fileWriter);
		PrintWriter out = new PrintWriter(buff);
		out.println(data);
		out.close();
		buff.close();
		fileWriter.close();
	}

	/*
		Generate Ramdom Numbers for a specific interval with a delay 
	*/
	public static void generateRamdomData(String fileName) throws Exception{
		long waitFor = (1000 * 60) * 5; // Generate Numbers for this much amount of time, and than exit.
		
		Thread t = new Thread(){
			
			@Override
			public void run(){
				Timer timer = new Timer();
				long delay = 1; // timegap between the numbers
				long period = 1; // timegap between the numbers
				
				try{
					timer.schedule(new TimerTask(){
						int num = 0;
						
						@Override
						public void run(){
							try{
								num = (int)(Math.random() * 1000000);								
								appendData(String.valueOf(num),fileName); // method call to write number in file
							}catch(Exception e){
								e.printStackTrace();
							}							
						}

					},delay,period);

					Thread.sleep(waitFor);
					timer.cancel();
				}catch(Exception e){
					e.printStackTrace();
				}						
			} // run

		}; // Thread t

		t.start(); // Start thread
	}
}

public class NomuraProblem{
	public static void main(String [] args){		
		try{
			//MyFileUtil.readFile("./myFileOne.txt");
			//MyFileUtil.writeFile("./myFileOne.txt");
			//MyFileUtil.generateRamdomData("./myFileOne.txt");
			MyFileUtil.readFileThanWrite("./myFileOne.txt","./myFileTwo.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
