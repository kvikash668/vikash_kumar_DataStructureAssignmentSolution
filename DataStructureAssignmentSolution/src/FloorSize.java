import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FloorSize {

	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int total_floor =sc.nextInt();
		
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> floorList=new ArrayList<>();
		
		
		for (int i = 1; i <= total_floor; i++) {
			System.out.println("enter the floor size given on day : " + i);
			map.put(i, sc.nextInt());
			floorList.add(map.get(i));
		}
		int initialFloor=total_floor;
		
		Map<Integer, List<Integer>> finalMap = new HashMap<>();
		
		List<Integer> visitedFloorList=new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			
			visitedFloorList.add(entry.getValue());
			
			if(entry.getValue()==initialFloor || entry.getKey()==total_floor) {
				
				Collections.sort(visitedFloorList,Collections.reverseOrder());
				
				List<Integer> list=new ArrayList<Integer>();
				
				
				int current=visitedFloorList.get(0);
				boolean res=true;
				
				List<Integer> temp=new ArrayList<Integer>();
				for(int num:visitedFloorList) {
					if(current==num) {
						list.add(num);
					}else {
						res=false;
						temp.add(num);
					}
					current--;
				}
				visitedFloorList=temp;
				finalMap.put(entry.getKey(),list);
				if(res) {
					visitedFloorList.clear();
				}
				initialFloor=list.get(list.size()-1)-1;
			}else {
				finalMap.put(entry.getKey(), new ArrayList<>());
			}
		}
		
		System.out.println("The order of construction is as follows");
		for(Map.Entry<Integer, List<Integer>> entry:finalMap.entrySet()) {
			System.out.println("Day: "+entry.getKey());
			for(int floor:entry.getValue()) {
				System.out.print(floor+" ");				
			}
			System.out.println();
		}
	}

}
