package model;

public class Horses extends Animals {
	
	
	private int cows;
	private int wolves;
	

	public Horses( int currentPopulation , int carCap, int cows) {
		super(currentPopulation, -0.09,1.5, 0.5, 1, carCap, 0.006);
		
}
	
    public Horses( int currentPopulation , int carCap) {
		super(currentPopulation,-0.09,1.5, 0.5, 0, carCap, 0.006);
		
}
    
    
    public Animals copy() {
	
		Horses clone = new Horses( this.cPopulation , this.carrCap);
		return clone;
		
	}
}



	




