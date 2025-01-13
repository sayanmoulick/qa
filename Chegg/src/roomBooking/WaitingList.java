package roomBooking;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingList {
	// this object will be used to create a queue from txt file data; to reduce I/O operations and increase throughput
	Queue<Customer> customerQueue = new LinkedList<Customer>(); // need to initialize this
	  
	//and include following methods: enqueue, dequeue, isEmpty. Feel free to include any additional properties and methods
	  
	public boolean enqueue(Customer customer){
		//System.out.println(customer.getCustName());
		return customerQueue.add(customer);
	}
	  
	public boolean dequeue(Customer customer){
	return customerQueue.remove(customer);
	}
	  
	public boolean isEmpty(){
	return customerQueue.isEmpty();
	}
	
}
