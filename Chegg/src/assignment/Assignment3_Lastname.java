package assignment;
import java.util.*;
public class Assignment3_Lastname {
	public static void init(int [] array) {
		for (int i=0; i<array.length ;i++) {
			if (array[i] == 98) {
				Human hObj = new Human("abc");
				hObj.setLife(array[i]);
			}
			if(array[i] == 95) {
				Machine mObj = new Machine("abc");
				mObj.setLife(array[i]);
			}
		}
	}
	public static void sing(String [] array) {
		for (int i=0; i<array.length ;i++) {
			Human hObj = new Human(array[i]);
			hObj.sing();
			Machine mObj = new Machine(array[i]);
			mObj.sing();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int life[] = {98, 95};
		init(life);
		String singer[] = { "Jyothi", "Jyostna", "Sumathi" };
		sing(singer);
	}

}


class Intelligence{
	String name;
	Intelligence(String o){
		this.name = o;
	}
	public String getName() {
        return name; 
    }
	void sing()
	{
		System.out.println("HAHA");
	}
	void play()
	{
		System.out.println("PAPA");
	}
	@Override
    public String toString() { 
        return String.format("Name: " + name); 
    }
}

class Human extends Intelligence{
	int life;
	boolean unplugged;
	Human(String o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	public void setLife(int x) {
	      this.life = x;
	}
	public int getLife() {
	      return life;
	}
	public void setUnplugged(boolean u) {
	      this.unplugged = u;
	}
	public boolean getUnplugged(boolean u) {
	      return unplugged;
	}
	void sing()
	{
		System.out.println("HAALLE");
	}
	void play()
	{
		System.out.println("ZOOWEE");
	}
	@Override
    public String toString() { 
        return String.format("Name: " + name + "; life: " + life + "; unplugged: " + unplugged); 
    }
}

class Machine extends Human{
	int energy;
	boolean exiled;
	Machine(String o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	public void setEnergy(int x) {
	      this.energy = x;
	}
	public int getEnergy() {
	      return energy;
	}
	public void setExiled(boolean u) {
	      this.exiled = u;
	}
	public boolean getExiled(boolean u) {
	      return exiled;
	}
	void sing()
	{
		System.out.println("LUUJAH");
	}
	void play()
	{
		System.out.println("MAAMAA");
	}
	@Override
	public String toString() { 
		return String.format("Name: " + name + "; energy: " + energy + "; exiled: " + exiled); 
	}
	
}