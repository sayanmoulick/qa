package roomBooking;

import java.util.LinkedList;

public class RoomList {
	// this object will be used to create a room list from txt file data; to reduce I/O operations and increase throughput
	private LinkedList<Room> roomList = new LinkedList<Room>(); // need to initialize this;
	  
	//add, remove, isEmpty. You may include any additional methods if you wish.
	public boolean add(Room room){
//		System.out.println(room.getRoomId());
		return roomList.add(room);
	}
	  
	public boolean remove(Room room){
		return roomList.remove(room);
	}
	  
	public boolean isEmpty(){
		return roomList.isEmpty();
	}
	
	public int size() {
		return roomList.size();
	}
	
	public void showAvailableRoom() {
		for(int num=0; num<roomList.size(); num++)
	      {
			System.out.println(roomList.get(num).getRoomId());
	      }
	}
	
	public boolean allotRoomById(int roomNo) {
		for(int num=0; num<roomList.size(); num++)
	      {
	    	  if(roomList.get(num).getRoomId().equals(String.valueOf(roomNo))) {
	    		  int idx = roomList.indexOf(roomList.get(num));
	    		  roomList.remove(idx);
	    		  return true;
	    	  }
	      }
		return false;
	}
  
}
