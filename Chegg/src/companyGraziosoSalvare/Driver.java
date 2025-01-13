package companyGraziosoSalvare;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {

		// Class variables

		// Create New Dog

		// Create New Monkey

		// Method to process request for a rescue animal

		// Method(s) to update information on existing animals

		// Method to display matrix of aninmals based on location and status/training phase

		// Method to add animals

		// Method to out process animals for the farm or in-service placement

		// Method to display in-service animals

		// Process reports from in-service agencies reporting death/retirement
		
		
		// Instance variables
    	Scanner scanner = new Scanner(System.in);
    	ArrayList<RescueAnimal> animals = new ArrayList<RescueAnimal>();

        // Create New Dog
    	Dog barkyBoy = new Dog();
  
        // Create New Monkey
    	Monkey throwsPoop = new Monkey();
    	
    	// call methods here as shown below
    	// processRequest("asia", animals);
    	
	}
        // Method to process request for a rescue animal
    	public static void processRequest(String inputCountry, ArrayList<RescueAnimal> animals) {
    		for (RescueAnimal animal : animals) {
    			if (animal.getTrainingLocation().equals(inputCountry)) {
    				animal.setStatus(true);
    			}
    		}
    	}
    	
        // Method(s) to update information on existing animals
    	public static void updateInfo(String name, ArrayList<RescueAnimal> animals) {
    		//Set up and print selection menu
    		Scanner scanner = new Scanner(System.in);
    		int option = -1;
    		while (option < 0 && option > 22) {
    			System.out.println("Please select an item to update from the menu:");
        		System.out.println("1 - Name");
        		System.out.println("2 - Age");
        		System.out.println("3 - Weight");
        		System.out.println("4 - Status Date");
        		System.out.println("5 - Reserved Status");
        		System.out.println("6 - Training Location");
        		System.out.println("7 - Training Start Date");
        		System.out.println("8 - Training End Date");
        		System.out.println("9 - Training Status");
        		System.out.println("10 - In-Service Country");
        		System.out.println("11 - In-Service City");
        		System.out.println("12 - In-Service Agency");
        		System.out.println("13 - In-Service POC");
        		System.out.println("14 - In-Service Email");
        		System.out.println("15 - In-Service Phone Number");
        		System.out.println("16 - In Service Postal Address");
        		System.out.println("17 - MONKEY ONLY: Tail Length");
        		System.out.println("18 - MONKEY ONLY: Height");
        		System.out.println("19 - MONKEY ONLY: Body Length");
        		System.out.println("20 - MONKEY ONLY: Torso Measurement");
        		System.out.println("21 - MONKEY ONLY: Skull Measurement");
        		System.out.println("22 - MONKEY ONLY: Neck Measurement");
        		System.out.println("0 - Exit");
        		option = scanner.nextInt();
        		System.out.println();
    		}
    		
    		//Deal with option selected from menu
    		switch(option) {
    		case 0:
    			return;
    			
    		case 1:
    			System.out.print("Enter new name: ");
    			String newNameValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setName(newNameValue);
    				}
    			}
    			break;
    			
    		case 2:
    			System.out.print("Enter new age: ");
    			int newAgeValue = scanner.nextInt();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setAge(newAgeValue);
    				}
    			}
    			break;
    			
    		case 3:
    			System.out.print("Enter new weight: ");
    			float newWeightValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setWeight(newWeightValue);
    				}
    			}
    			break;
    			
    		case 4:
    			System.out.print("Enter new status date: ");
    			SimpleDateFormat newStatusDateValue = new SimpleDateFormat(scanner.next());
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setStatusDate(newStatusDateValue);
    				}
    			}
    			break;
    			
    		case 5:
    			System.out.print("Enter new reserved status (true = is reserved, false = is not reserved): ");
    			boolean newReservedStatusValue = scanner.nextBoolean();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setStatus(newReservedStatusValue);
    				}
    			}
    			break;
    			
    		case 6:
    			System.out.print("Enter new training location: ");
    			String newTrainingLocationValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setTrainingLocation(newTrainingLocationValue);
    				}
    			}
    			break;
    			
    		case 7:
    			System.out.print("Enter new training start date: ");
    			SimpleDateFormat newTrainingStartDateValue = new SimpleDateFormat(scanner.next());
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setTrainingStart(newTrainingStartDateValue);
    				}
    			}
    			break;
    			
    		case 8:
    			System.out.print("Enter new training end date: ");
    			SimpleDateFormat newTrainingEndDateValue = new SimpleDateFormat(scanner.next());
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setTrainingEnd(newTrainingEndDateValue);
    				}
    			}
    			break;
    			
    		case 9:
    			System.out.print("Enter new training status: ");
    			String newTrainingStatusValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setTrainingStatus(newTrainingStatusValue);
    				}
    			}
    			break;
    			
    		case 10:
    			System.out.print("Enter new in-service country: ");
    			String newInServiceCountryValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServiceCountry(newInServiceCountryValue);
    				}
    			}
    			break;
    			
    		case 11:
    			System.out.print("Enter new in-service city: ");
    			String newInServiceCityValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServiceCity(newInServiceCityValue);
    				}
    			}
    			break;
    			
    		case 12:
    			System.out.print("Enter new in-service agency: ");
    			String newInServiceAgencyValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServiceAgency(newInServiceAgencyValue);
    				}
    			}
    			break;
    			
    		case 13:
    			System.out.print("Enter new in-service POC: ");
    			String newInServicePOCValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServicePOC(newInServicePOCValue);
    				}
    			}
    			break;
    			
    		case 14:
    			System.out.print("Enter new in-service email: ");
    			String newInServiceEmailValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServiceEmail(newInServiceEmailValue);
    				}
    			}
    			break;
    			
    		case 15:
    			System.out.print("Enter new in-service phone number: ");
    			String newInServicePhoneNumberValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServicePhone(newInServicePhoneNumberValue);
    				}
    			}
    			break;
    			
    		case 16:
    			System.out.print("Enter new in-service postal address: ");
    			String newInServicePostalAddressValue = scanner.next();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name)) {
    					animal.setInServicePostalAddress(newInServicePostalAddressValue);
    				}
    			}
    			break;
			// Are you maintaining any hierarchy or calling any method randomly
			// I wonder why the method of Monkey class is calling from RescueAnimal object from Case 17 to Case 22?	
    		case 17:
    			System.out.print("Enter new tail length: ");
    			float newTailLengthValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setTailLength(newTailLengthValue); 
    				}
    			}
    			break;
    		
    		case 18:
    			System.out.print("Enter new height:  ");
    			float newHeightValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setHeight(newHeightValue);
    				}
    			}
    			break;
    			
    		case 19:
    			System.out.print("Enter new body length: ");
    			float newBodyLengthValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setBodyLength(newBodyLengthValue);
    				}
    			}
    			break;
    			
    		case 20:
    			System.out.print("Enter new torso measurement: ");
    			float newTorsoMeasurementValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setTorsoMeasurement(newTorsoMeasurementValue);
    				}
    			}
    			break;
    			
    		case 21:
    			System.out.print("Enter new skull measurement: ");
    			float newSkullMeasurementValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setSkullMeasurement(newSkullMeasurementValue);
    				}
    			}
    			break;
    			
    		case 22:
    			System.out.print("Enter new neck measurement: ");
    			float newNeckMeasurementValue = scanner.nextFloat();
    			System.out.println();
    			
    			for (RescueAnimal animal : animals) {
    				if (animal.getName().equals(name) && animal instanceof Monkey) {
    					animal.setNeckMeasurement(newNeckMeasurementValue);
    				}
    			}
    			break;
    		}
    		
    	}


        // Method to display matrix of animals based on location and status/training phase
    	public static void outputAnimals(String trainingLocation, String trainingStatus, ArrayList<RescueAnimal> animals) {
    		for (RescueAnimal animal : animals) {
    			System.out.println("Name: " + animal.getName());
    			//if the animal is in service, this will print the city/country
    			if (animal.getTrainingStatus().equals("service")) {
    				System.out.println("Location: " + animal.getInServiceCity() + ", " + animal.getInServiceCountry());
    			}
    			//if the animal is at the farm, it will print the location of the training facility farm
    			else if (animal.getTrainingStatus().equals("farm")) {
    				System.out.println("Location: " + animal.getTrainingLocation());
    			}
    			//if the above two fail, meaning the animal is in training, it will print the facility
    			//as well as the phase of training the animal is in
    			else {
    				System.out.println("Location: " + animal.getTrainingLocation());
        			System.out.println("Phase: " + animal.getTrainingStatus());
    			}
    			System.out.println();
    		}
    	}

        // Method to add animals
    	public static void addAnimal(RescueAnimal animal, ArrayList<RescueAnimal> animals) {
    		animals.add(animal);
    	}

        // Method to out process animals for the farm or in-service placement
    	public static void outProcess(String name, String status, ArrayList<RescueAnimal> animals) {
    		for (RescueAnimal animal : animals) {
    			if (animal.getName().equals(name)) {
    				animal.setTrainingStatus(status);
    			}
    		}
    	}

        // Method to display in-service animals
    	public static void outputInServiceAnimals(ArrayList<RescueAnimal> animals) {
    		for (RescueAnimal animal : animals) {
    			if (animal.getTrainingStatus().equals("service")) {
    				System.out.println(animal.getName() + " is in-service.");
    			}
    		}
    	}

        // Process reports from in-service agencies reporting death/retirement
    	public static void removeAnimal(String name, ArrayList<RescueAnimal> animals) {
    		for (RescueAnimal animal : animals) {
    			if (animal.getName().equals(name)) {
    				animals.remove(animal);
    			}
    		}
    	}
}
