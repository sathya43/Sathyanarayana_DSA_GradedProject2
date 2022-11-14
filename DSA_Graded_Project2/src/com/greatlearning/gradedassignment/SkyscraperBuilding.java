package com.greatlearning.gradedassignment;

import java.util.*;
import java.io.*;

public class SkyscraperBuilding {
	
	static class Pair{
		int size;
		int day;
		
		Pair(){
			
		}
		
		Pair(int size, int day){
			this.size = size;
			this.day = day;
		}
	}

	static class SortBySize implements Comparator<Pair>{
		  public int compare(Pair a, Pair b)
		    {
		 
		        return b.size - a.size;
		    }
	}
	
	static class SortByNumber implements Comparator<Integer>{
		  public int compare(Integer a, Integer b)
		    {
		 
		        return b - a;
		    }
	}
	

	 public static void main(String[] args) {
		 
		 int no_of_floors;
		 System.out.println("enter the total no of floors in the building: ");
		 
		 Scanner sc = new Scanner(System.in);
		 no_of_floors = sc.nextInt();
		 
		 
	/*
	 * Solution approach:
	 *
	 * Data structures maintained: ArrayList<Pair> and Hashmap<Imteger, ArrayList>
	 * 
	 * 1. ArrayList stores a Pair element. Pair contains bilding built on day and its size
	 * 
	 * 
	 * Step 1: We take input of day and building built on the day along with its size. We form a pair and push into arraylst
	 * 
	 * Step 2: After taking all inputs, we sort the array depending on the size of the building in descending order
	 * 
	 * Step 3. We try to take building of largest size available and try placing it on the earliest day possible once it is available.
	 *
	 * 
	 */
		 
		 ArrayList<Pair> arr = new ArrayList<Pair>();
		 
		
		 
		 for(int i = 1;i<=no_of_floors;i++) {
			 int size_of_building;
			 System.out.println("enter the floor size given on day: " + i);
			 size_of_building = sc.nextInt();
			 Pair pair = new Pair(size_of_building,i);
			 arr.add(pair);
			 
		
		}
		 
		 arr.sort(new SortBySize());
		 
		 HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		 int day_To_Insert = arr.get(0).day;
		 
		 for(Pair it:arr) {
			 int key = it.day;
			 System.out.println(it.size + "******" + it.day);
			 if(it.day <=day_To_Insert) {
				 if(map.get(day_To_Insert) == null) {
						map.put(day_To_Insert, new ArrayList<Integer>());
						map.get(day_To_Insert).add(it.size);
					}else {
						map.get(day_To_Insert).add(it.size);
					}
			 }else {			 
					if(map.get(key) == null) {
						map.put(key, new ArrayList<Integer>());
						map.get(key).add(it.size);
					}else {
						map.get(key).add(it.size);
					}
					day_To_Insert = it.day;
			 }
			 
		 }
		 
		 System.out.println("The order of construction is as follows");
		 for(int i = 1;i<=no_of_floors;i++) {
			 System.out.println("Day " + i);
			 if(map.get(i) != null) {
				 ArrayList<Integer> list = map.get(i);
				 list.sort(new SortByNumber());
				 int sz = list.size();
				 for(int j = 0; j < sz;j++) {
					 if(list.size() > 0) {
					 System.out.print(list.get(j) + " ");
					 }
				 }
			 }
			 System.out.println();
		 }
		 
		 
		 
		 
		 
	 }
}
