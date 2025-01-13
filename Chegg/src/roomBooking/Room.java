package roomBooking;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable{
  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roomId;
	private Date bookingDate;
	private Date check_In_Date;
	private Date check_Out_Date;
	private String type_Of_Room;
	private String other_Services;
	private double price;
  
	public Room() {
	super();
	}
	  
	public Room(String roomId){
	this.roomId=roomId;
	}
	
	public Room(String roomId, Date bookingDate, Date check_In_Date, Date check_Out_Date, String type_Of_Room,
	String other_Services, double price) {
	super();
	this.roomId = roomId;
	this.bookingDate = bookingDate;
	this.check_In_Date = check_In_Date;
	this.check_Out_Date = check_Out_Date;
	this.type_Of_Room = type_Of_Room;
	this.other_Services = other_Services;
	this.price = price;
	}
	
	public String getRoomId() {
	return roomId;
	}
	
	public void setRoomId(String roomId) {
	this.roomId = roomId;
	}
	
	public Date getBookingDate() {
	return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
	this.bookingDate = bookingDate;
	}
	
	public Date getCheck_In_Date() {
	return check_In_Date;
	}
	
	public void setCheck_In_Date(Date check_In_Date) {
	this.check_In_Date = check_In_Date;
	}
	
	public Date getCheck_Out_Date() {
	return check_Out_Date;
	}
	
	public void setCheck_Out_Date(Date check_Out_Date) {
	this.check_Out_Date = check_Out_Date;
	}
	
	public String getType_Of_Room() {
	return type_Of_Room;
	}
	
	public void setType_Of_Room(String type_Of_Room) {
	this.type_Of_Room = type_Of_Room;
	}
	
	public String getOther_Services() {
	return other_Services;
	}
	
	public void setOther_Services(String other_Services) {
	this.other_Services = other_Services;
	}
	
	public double getPrice() {
	return price;
	}
	
	public void setPrice(double price) {
	this.price = price;
	}
  
  

}
