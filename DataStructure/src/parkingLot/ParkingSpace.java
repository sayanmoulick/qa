package parkingLot;

import parkingLot.Car.*;
import java.io.*;
import java.util.Scanner; 

public class ParkingSpace {	
	
	  
	// Java program to implement 
	// a Singly Linked List 
	  
	    Node head; // head of list 
	  
	    // Linked list Node. 
	    // This inner class is made static 
	    // so that main() can access it 
	    static class Node { 
	  
	        Car data; 
	        Node next; 
	  
	        // Constructor 
	        Node(Car d) 
	        { 
	            data = d; 
	            next = null; 
	        } 
	    } 
	  
	    // **************INSERTION************** 
	  
	    // Method to insert a new node 
	    public static ParkingSpace insert(ParkingSpace list, Car data) 
	    { 
	        // Create a new node with given data 
	        Node new_node = new Node(data); 
	        new_node.next = null; 
	  
	        // If the Linked List is empty, 
	        // then make the new node as head 
	        if (list.head == null) { 
	            list.head = new_node; 
	        } 
	        else { 
	            // Else traverse till the last node 
	            // and insert the new_node there 
	            Node last = list.head; 
	            while (last.next != null) { 
	            	if(last.data == new Car()) {
	            		last.data=data;
	            		return list;
	            	}
	            	else {
	            		last = last.next;
	            	}
	            		
	            } 
	  
	            // Insert the new_node at last node 
	            last.next = new_node; 
	        } 
	  
	        // Return the list by head 
	        return list; 
	    } 
	  
	    // **************TRAVERSAL************** 
	  
	    // Method to print the LinkedList. 
	    public static void updateParkingSpace(ParkingSpace list) 
	    { 
	        Node currNode = list.head; 
	  
	        System.out.print("\nLinkedList: "); 
	  
	        // Traverse through the LinkedList 
	        while (currNode != null) { 
	            // Print the data at current node 
	            System.out.print(currNode.data + " "); 
	  
	            // Go to next node 
	            currNode = currNode.next; 
	        } 
	        System.out.println("\n"); 
	    } 
	  
	    // **************DELETION BY KEY************** 
	  
	    // Method to delete a node in the LinkedList by KEY 
	    public static ParkingSpace deleteByKey(ParkingSpace list, Car key) 
	    { 
	        // Store head node 
	        Node currNode = list.head, prev = null; 
	  
	        // 
	        // CASE 1: 
	        // If head node itself holds the key to be deleted 
	  
	        if (currNode != null && currNode.data == key) { 
	            // list.head = currNode.next; // Changed head 
	        	list.head.data = new Car();
	            // Display the message 
	            System.out.println(key + " found and deleted"); 
	  
	            // Return the updated List 
	            return list; 
	        } 
	  
	        // 
	        // CASE 2: 
	        // If the key is somewhere other than at head 
	        // 
	  
	        // Search for the key to be deleted, 
	        // keep track of the previous node 
	        // as it is needed to change currNode.next 
	        while (currNode != null && currNode.data != key) { 
	            // If currNode does not hold key 
	            // continue to next node 
	            prev = currNode; 
	            currNode = currNode.next; 
	        } 
	  
	        // If the key was present, it should be at currNode 
	        // Therefore the currNode shall not be null 
	        if (currNode != null) { 
	            // Since the key is at currNode 
	            // Unlink currNode from linked list 
	            //prev.next = currNode.next; 
	        	currNode.data=new Car();
	            // Display the message 
	            System.out.println(key + " found and deleted"); 
	        } 
	  
	        // 
	        // CASE 3: The key is not present 
	        // 
	  
	        // If key was not present in linked list 
	        // currNode should be null 
	        if (currNode == null) { 
	            // Display the message 
	            System.out.println(key + " not found"); 
	        } 
	  
	        // return the List 
	        return list; 
	    } 
	  
	  
	    // **************MAIN METHOD************** 
	  
	    // method to create a Singly linked list with n nodes 
	    public static void main(String[] args) 
	    { 
	    	System.out.println("Enter Total Parking Slot : ");
			Scanner sc = new Scanner(System.in);
			int totalParkingSlot = sc.nextInt();
			int occupiedParkingSlot = 0;
			ParkingSpace parkingSpace = new ParkingSpace();
			Car car1 = new Car("Red", "Aston Martin", "7thFeb2020");
	        Car car2 = new Car("Black", "Ford", "8thMar2020");
	        Car car3 = new Car("White", "Audi", "9thApr2020");
	        Car car4 = new Car("Red", "Aston Martin", "10thMay2020");
	        Car car5 = new Car("Black", "Ford", "11thJun2020");
	        Car car6 = new Car("White", "Audi", "12thJul2020");
			do {
				if(occupiedParkingSlot < totalParkingSlot) {
					System.out.print("Enter dock (to Allocate) or undock (to De-Allocate): ");
				    String letter = sc.nextLine();
				    switch (letter) {
				    case "dock":
						//System.out.println("Enter Car Name : ");
						//String carName = sc.nextLine();
						parkingSpace = insert(parkingSpace, car1);
						parkingSpace = insert(parkingSpace, car2);
						parkingSpace = insert(parkingSpace, car3);
						occupiedParkingSlot+=occupiedParkingSlot;
						// updateParkingSpace(parkingSpace);
						break;
				    case "undock":
				    	// System.out.println("Enter Car Name : ");
						// carName = sc.nextLine();
						deleteByKey(parkingSpace, car1);
						occupiedParkingSlot-=occupiedParkingSlot;
						// updateParkingSpace(parkingSpace);
				    	break;
				    default:
				    	System.out.println("Enter Correct Option");
				    	break;
				    }
				}
				else {
					// System.out.println("Enter Car Name to De-Allocate: ");
					// carName = sc.nextLine();
					deleteByKey(parkingSpace, car3);
					occupiedParkingSlot-=occupiedParkingSlot;
				}
			}while(true);
	    } 
	} 

