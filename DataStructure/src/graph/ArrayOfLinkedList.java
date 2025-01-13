package graph;

import java.util.*;

public class ArrayOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*List<Integer> l = new LinkedList<>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(0, 100);
//		System.out.println(l);
		for(Integer i: l) {
			System.out.println(i);
		}*/
		
		List<Integer> l[] = new LinkedList[10];
		for(int i=0; i<10; i++)
			l[i] = new LinkedList<Integer>();
		l[0].add(10); l[0].add(20); l[0].add(30);
		for(int i=0; i<10; i++)
			System.out.println(i +"==>"+ l[i]);
	}

}
