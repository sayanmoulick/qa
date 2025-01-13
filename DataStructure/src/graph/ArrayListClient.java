package graph;


import java.util.Arrays;

import java.util.Iterator;

import java.util.NoSuchElementException;

import java.util.Iterator;

import java.util.ListIterator;

class ArrayList<E> {

	private E[] elementData;
	
	// current number of elements in the list
	
	private int size;
	
	public static final int DEFAULT_CAPACITY = 100;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
	
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		elementData = (E[]) new Object[capacity];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public E get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	
	public String toString() {
	
		if(size ==0) {
			return "[]";
		}
		else {
			String result = "[" + elementData[0];
			for(int i =1;i<size;i++) {
			result += ", " +elementData[i];
			}
			result +="]";
			return result;
		}
	}
	
	public int indexOf(E value) {
		for(int i=0;i<size;i++) {
			if(elementData[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public boolean contains(E value) {
		return indexOf(value) >=0;	
	}
	
	public boolean containsAll(ArrayList<E> list) {
		for(int i=0;i<list.size();i++) {
			if(!contains(list.elementData[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void add(E value) {
		ensureCapacity(size + 1);
		elementData[size] = value;
		size++;
	}
	
	public void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ensureCapacity(size + 1); //this public method throws the exception
		for(int i = size; i>index+1; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = value;
		size++;
	}
	
	public void addAll(int index, ArrayList<E> list) {	
		ensureCapacity(list.size+1);
		for(int i=0; i<list.size();i++) {
			add(index,list.elementData[i]);
			index++;
		}
	}
	
	public void remove(int index) {
		checkIndex(index);
		for(int i = index; i<size-1;i++) {
			elementData[i] = elementData[i+1];
		}
		elementData[size-1]=null;
		size--;
	}
	
	public void removeAll(ArrayList<E> list) {
		for(int i=0; i<list.size();i++) {
			int index = indexOf(list.elementData[i]);
			if(index>0)
				remove(index);
		}	
	}
	
	public void set(int index, E value) {
		checkIndex(index);
		elementData[index] = value;
	}
	
	public void clear() {
		for(int i=0; i<size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}
	
	public void addAll(ArrayList<E> other) {
		ensureCapacity(size + other.size);
		for(int i=0; i<other.size; i++) {
			add(other.elementData[i]);
		}
	}
	
	public Iterator<E> iterator(){
		return new ArrayListIterator2();
	}
	
	public void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity; 
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}	
	}
	
	public void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	private class ArrayListIterator2 implements Iterator<E> {
	
		private int position;
		private boolean removeOK;
		
		public ArrayListIterator2() {
			position = 0;
			removeOK =false;
		}
		
		public boolean hasNext() {
			return position < size();
		}
		public boolean hasPrevious() {
			return position > size();
		}

		public E previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			E result = elementData[position];
			position++;
			removeOK =true;
			return result;
		}
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = elementData[position];
			position++;
			removeOK =true;
			return result;
		}
		
		public void remove() {		
			if(!removeOK) {
				throw new IllegalStateException();
			}
			ArrayList.this.remove(position-1);
			position--;
			removeOK =false;
		}
		
		public void add(E value) {
			ArrayList.this.add(value);
			position++;
		}
		
		public void set(E value) {		
			ArrayList.this.set(position, value);
		}
		
		

	
	}

	public int previousIndex() {
		return size-1;
	}
	public int nextIndex() {
		return size;
	}
}



public class ArrayListClient {

	public static void main(String[] args) {
	
		int[] data1 = { 11, 12, 54, 76, 46, 12, 67, 33, 27, 89, 27 };
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		for (int n : data1) {
			list1.add(n);
		}
		
		Iterator<Integer> i = list1.iterator();

		while (i.hasNext()) {
			int n = i.next();
			System.out.println(n);
		}
		
		System.out.println("Previous Index: " + list1.previousIndex());
		list1.add(19);
		while (i.hasNext()) {
			int n = i.next();
			System.out.println("After adding new element " + n +" at index " +list1.previousIndex());
		}
		ListIterator<Integer> j = (ListIterator<Integer>) list1.iterator();
		while (j.hasPrevious()) {
			int n = j.previous();
			System.out.println(n);
		}
	    System.out.println("Next Index: " + list1.nextIndex());
		System.out.println("\nList elements of list1: " + list1+"\n");

	}

}
