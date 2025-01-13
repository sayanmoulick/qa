package companyGraziosoSalvare;

import java.text.SimpleDateFormat;

public class RescueAnimal extends Monkey{
	// Class variables
	private String name;
	private String type;
	private String gender;
	private int age;
	private float weight;
	private SimpleDateFormat acquisitionDate;
	private SimpleDateFormat statusDate;
	private String acquisitionSource;
	private Boolean reserved;

	private String trainingLocation;
	private SimpleDateFormat trainingStart;
	private SimpleDateFormat trainingEnd;
	private String trainingStatus;

	private String inServiceCountry;
	private String inServiceCity;
	private String inServiceAgency;
	private String inServicePOC;
	private String inServiceEmail;
	private String inServicePhone;
	private String inServicePostalAddress;

	// Constructor
	public RescueAnimal() {
	}
	public RescueAnimal(String name, String type, int age, float weight, SimpleDateFormat acquisitionDate, String acquisitionSource) {
	}
	
	// Add Accessor Methods here
	public String getName() {
  	  return name;
    } // gets the name of the animal
	
	public String getType(){
  	  return type;
    } // gets ether if it is a monkey or dog
	
	public String getGender(){
  	  return gender; 
    } // gets gender animal

	public int getAge(){
  	  return age; 
    } // gets age animal
	
    public float getWeight(){
  	  return weight; 
    } // gets weight of animal 
    
    public SimpleDateFormat getAcquisitionDate(){
    	  return acquisitionDate; 
    }
    
    public SimpleDateFormat getStatusDate(){
  	  return statusDate; 
    }
    
    public String getAcquisitionSource() {
  	  return acquisitionSource; 
    } // get were the animal is from
    
    
	public boolean getReserved() {
	  return reserved;
	}
	
	public String getTrainingLocation() {   	  
	  return trainingLocation;     	  
	}
	
	public SimpleDateFormat getTrainingStart() { 
  	  return trainingStart;
    }
	
	public SimpleDateFormat getTrainingEnd() { 
  	  return trainingEnd;
    }
	
	public String getTrainingStatus() {
      return trainingStatus;
    }// Gets training status 
      
	public String getInServiceCountry() {
	  return inServiceCountry;
	}
    
	public String getInServiceCity() {
	  return inServiceCity;
	}
    
	public String getInServiceAgency() {
	  return inServiceAgency;
	}
	
	public String getInServicePOC() {
	  return inServicePOC;
	}
    
	public String getInServiceEmail() {
	  return inServiceEmail;
	}
	
	public String getInServicePhone() {
	  return inServicePhone;
	}
	
	public String getInServicePostalAddress() {
	  return inServicePostalAddress;
	}
  
	// Add Mutator Methods here
	public void setName(String name) {
  	  this.name = name;
    }
	
	public void setType(String type) {
  	  this.type = type;
    }
	
	// sets the age of the animal
    public void setAge(int age){
  	  this.age = age;	  
    }
    // sets the weight of the animal
    public void setWeight(float weight){
  	  this.weight = weight;	  
    }
    
    public void setAcquisitionDate (SimpleDateFormat acquisitionDate) {
      this.acquisitionDate   = acquisitionDate;
    }
    
    public void setStatusDate (SimpleDateFormat statusDate) {
	  this.statusDate = statusDate;
	}
    
    // sets the source of the animal is from
    public void setAcquisitionSource (String acquisitionSource) {
  	  this.acquisitionSource = acquisitionSource;
    }
    
    public void setStatus(boolean reserved) {
	  this.reserved = reserved;
	}
    
    // sets the training location of the animal
    public void setTrainingLocation(String trainingLocation){
  	  this.trainingLocation = trainingLocation;  
    }
    
    public void setTrainingStart (SimpleDateFormat trainingStart) {
  	  this.trainingStart = trainingStart;
  	}
    
    public void setTrainingEnd (SimpleDateFormat trainingEnd) {
	  this.trainingEnd = trainingEnd;
	}
    
    public void setTrainingStatus (String trainingStatus) {
	  this.trainingStatus = trainingStatus;
	}
    
    // sets the in service country were the animal is at
    public void setInServiceCountry(String inServiceCountry) {
    	this.inServiceCountry = inServiceCountry;
    }
    
    // sets the in service city that the rescue animal is at
    public void setInServiceCity(String inServiceCity) {
    	this.inServiceCity = inServiceCity;
    }
    
	// sets the that the in service animal is located at
    public void setInServiceAgency(String inServiceAgency) {
    	this.inServiceAgency = inServiceAgency;
    	
    }    
    
    // sets the inservice POC of the rescue animal
    public void setInServicePOC(String inServicePOC) {
    	this.inServicePOC = inServicePOC;
    }
    // sets the email of the agency that the rescue animal is at 
    public void setInServiceEmail(String inServiceEmail) {
    	this.inServiceEmail = inServiceEmail;
    }
    // sets the in service agency's phone number that the rescue animal is at 
    public void setInServicePhone (String inServicePhone) {
    	this.inServicePhone = inServicePhone;
    }  
    // sets the in service agency's postal address that the rescue animal is at 
    public void setInServicePostalAddress(String inServicePostalAddress) {
    	this.inServicePostalAddress = inServicePostalAddress;
    }
}
