package model;



public class Wolves extends Animals {

	public Wolves(int cPopulation, double bRate, double dRate) {
		super(cPopulation, bRate, dRate);
		// TODO Auto-generated constructor stub
	}
	
    public Wolves( int currentPopulation , int carCap) {
		super(currentPopulation,-0.18,1.5, 0.5, 0, carCap, 0.016);
		
}
    
    
    public Animals copy() {
	
		Wolves clone = new Wolves( this.cPopulation , this.carrCap);
		return clone;
	}
}
	
