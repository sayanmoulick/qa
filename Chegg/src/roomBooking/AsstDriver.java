package roomBooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
public class AsstDriver {

	public static void main(String[] args) throws Exception{
		WaitingList wl = new WaitingList();
		RoomList rl = new RoomList();
		
		picksCustomerInTheWaitingList(wl, rl);
		allotRoomToCustomer(wl, rl);
	}
	
	//It picks the first customer in the waiting list, and then scans the list of available rooms
	private static void picksCustomerInTheWaitingList(WaitingList wl, RoomList rl) throws IOException {
		Scanner scanner = new Scanner(System.in);
//		File file = new File("D://srikanth/Q5/WaitingCustomers.txt");
		File file = new File("/home/sayan/Desktop/WaitingCustomers.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		  
		/* Add to queue from waitingCustomers file */
		while((line = br.readLine()) != null){
			String[] waitingCust=line.split("\\|");
			Customer cust = new Customer();
			cust.setCustName(waitingCust[0].trim());
			cust.setRequirements(waitingCust[1].trim());
			wl.enqueue(cust);
		}
		
		/* end of data insertion to queue*/
		
		//	File availableRoomsFile= new File("D://srikanth/Q5/AvailableRooms.txt");
		File availableRoomsFile= new File("/home/sayan/Desktop/AvailableRooms.txt");
		FileReader availableRoomsFileReader = new FileReader(availableRoomsFile);
		BufferedReader availableRoomsBufferedReader = new BufferedReader(availableRoomsFileReader);
		String availableRooms;
		
		/* Add to linkedList from AvailableRooms file */
		while((availableRooms = availableRoomsBufferedReader.readLine()) !=null){
			String[] availableRooms1=availableRooms.split(" ");
			Room room = new Room();
			room.setRoomId(availableRooms1[0]);
//			room.setType_Of_Room(availableRooms1[1]);
			
			rl.add(room);
		}
		/* end of data insertion to linkedList*/
		//close resources
		br.close();
		fr.close();
	}

	
	private static void allotRoomToCustomer(WaitingList wl, RoomList rl) throws IOException {
//		System.out.println(wl.customerQueue.element());
		/*for(Customer item : wl.customerQueue){
		    System.out.println(item.getCustName());
		}*/
		Scanner scanner = new Scanner(System.in);
		
		
		while(wl.customerQueue != null) {
			if(wl.isEmpty() == true) {
				System.out.println("No Customer in the queue");
				System.exit(0);
			}
			else {
//				System.out.println(wl.customerQueue.element());
//				System.out.println(rl.size());
				System.out.println("Available Rooms: ");
				rl.showAvailableRoom();
				System.out.println("Please enter the room no : ");
				int roomNo=scanner.nextInt();
				rl.allotRoomById(roomNo);
				wl.dequeue(wl.customerQueue.element());
				System.out.println(((Customer) wl.customerQueue.element()).getCustName() + " Alloted to room No : " + roomNo);
			}
			
		}
		
//		while((line = br.readLine()) != null){
////			System.out.println(line);
//			//process the line
//			String[] waitingCust=line.split("\\|");
//			Customer cust = new Customer();
//			cust.setCustName(waitingCust[0].trim());
//			cust.setRequirements(waitingCust[1].trim());
////			System.out.println(Arrays.toString(waitingCust));
//
//			while((availableRooms = availableRoomsBufferedReader.readLine()) !=null){
//				System.out.println("Available Rooms: ");
//				System.out.println(availableRooms);
//				String[] availableRooms1=availableRooms.split(" ");
//				Room room = new Room();
//				room.setRoomId(availableRooms1[0]);
//				System.out.println("-->" + room.getRoomId());
////				room.setType_Of_Room(availableRooms1[1]);
//				/*if(cust.getRequirements()==room.getType_Of_Room()){
//				//availableRoomsBufferedReader.
//				}
//			  */
//			}
//			/* System.out.println("Please enter the room no : ");
//			int roomNo=scanner.nextInt();*/
//			  
//		}
		
	}
}
