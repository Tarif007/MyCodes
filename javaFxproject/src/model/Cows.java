package model;

public class Cows extends Animals {
	
	
	private int horses;
	private int wolves;
	

    public Cows( int currentPopulation , int carCap, int horse) {
		super(currentPopulation,-0.18,1.5, 0.5, 0, carCap, 0.016);
		

	}
    public Cows( int currentPopulation , int carCap) {
		super(currentPopulation,-0.18,1.5, 0.5, 0, carCap, 0.016);
		

	}
    
    
    public Animals copy() {
	
		Cows clone = new Cows( this.cPopulation , this.carrCap);
		return clone;
		
	}
}
