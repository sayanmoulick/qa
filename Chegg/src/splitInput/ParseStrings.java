package splitInput;

import java.util.Scanner;

public class ParseStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        String inputStr="";
        do { // take input in a loop
        	System.out.println("Enter input string: ");
        	inputStr= input.nextLine();              //reads string
        	if(!inputStr.equals("q")) { // continue if inputStr is not 'q'
        		String[] parts = inputStr.split(",");
                if (parts.length > 1) {
                	System.out.println("First Word: "+ parts[0].trim());
                	System.out.println("Second Word: "+ parts[1].trim());
                }
                else {
                	System.out.println("Error: No comma in string");
                }
        	}
        	else { // Terminate program if inputStr is 'q'
        		System.exit(0);
        	}
        }while(true);
         
	}

}
