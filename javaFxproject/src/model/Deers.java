package model;

public class Deers extends Animals {

	
	private int wolves;
	

    public Deers( int currentPopulation , int carCap) {
		super(currentPopulation, -0.17,0, 0, 2, carCap, 0.005);
		
}
	
   
    public Animals copy() {
	
		Deers clone = new Deers ( this.cPopulation , this.carrCap);
		return clone;
		
	}
}

