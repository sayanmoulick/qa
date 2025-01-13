package ticketingSystem;

import parkingLot.Car;
import ticketingSystem.CarQueue;

public class AllotCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CarQueue carQueue = new CarQueue(10); // create a Queue of Car capacity 10
		Car car1 = new Car("Red", "Aston Martin", "7thFeb2020"); // create a New Car
        Car car2 = new Car("Black", "Ford", "8thMar2020"); // create a New Car
        Car car3 = new Car("White", "Audi", "9thApr2020"); // create a New Car
        carQueue.enqueue(car1);
        carQueue.enqueue(car2);
        carQueue.enqueue(car3);
		
		System.out.println("Front element is: " + carQueue.peek());
		carQueue.dequeue();
		System.out.println("Front element is: " + carQueue.peek());

		System.out.println("Queue size is " + carQueue.size());

		carQueue.dequeue();
		carQueue.dequeue();
		
		if (carQueue.isEmpty())
			System.out.println("Queue Is Empty");
		else
			System.out.println("Queue Is Not Empty");
	}

}
