package parkingLot;

public class Car {
//	private int yearModel;
	private String carColour;
    private String brandName;
    private String registrationNumber;
//    private int priceModel;
//    private int numberModel;

    public Car()
    {
//    	carColour = "NA"; 
    }
    
    public Car(String a, String b, String c)
    {
    	carColour = a;
    	brandName = b;
    	registrationNumber = c;
//      yearModel = year;
//      priceModel = price;
//      numberModel = number;      
    }

   /* public int getYear()                
    {
        return yearModel;
    } */

    public String getCarColour()
    {
        return carColour;
    }

    public String getBrandName()
    {
        return brandName;
    }
    
    public String getRegistrationNumber()
    {
        return registrationNumber;
    }
   /* public int getPrice()
    {
        return priceModel;
    }

    public int getNumber()
    {
        return numberModel;
    } 

    public void setYear(int year)
    {
        yearModel = year;
    } */

    public void setCarColour(String carColor)
    {
    	carColour = carColor;
    }

    public void setBrandName(String carBrand)
    {
    	brandName = carBrand;
    }
    
    public void setRegistrationNumber(String carNumber)
    {
    	registrationNumber = carNumber;
    }
   /* public void setPrice(int price)                        
    {
        priceModel = price;   
    }
    
    public void setNumber(int number)
    {
        numberModel = number;
    } */

}
