package roomBooking;

public class Customer {
	  
	private int custID;
	private String custName;
	private String requirements;
	  
	public Customer() {
	super();
	}
	
	public Customer(int custID, String custName, String requirements) {
	super();
	this.custID = custID;
	this.custName = custName;
	this.requirements = requirements;
	}
	
	public int getCustID() {
	return custID;
	}
	
	public void setCustID(int custID) {
	this.custID = custID;
	}
	
	public String getCustName() {
	return custName;
	}
	
	public void setCustName(String custName) {
	this.custName = custName;
	}
	
	public String getRequirements() {
	return requirements;
	}
	
	public void setRequirements(String requirements) {
	this.requirements = requirements;
	}
  

}
