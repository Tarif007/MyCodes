package model;

public abstract class Animals {
	
	protected int cPopulation;
	protected int carrCap;
	protected double insRate;
	protected double alpha;
	protected double beta;
	protected double capEfficiency;	
	protected int wolves;
	protected int switchSituation;
	protected double bRate = 0.6;
	protected double dRate = 0.4;
	
	
    public Animals(int cPopulation, double insRate, double alpha, double beta,
			int switchSituation, int carrCap, double capEfficiency) {
		super();
		this.cPopulation = cPopulation;
		this.carrCap = carrCap;
		this.insRate = insRate;
		this.alpha =1.5;
		this.beta = 0.5;
		this.capEfficiency = capEfficiency;
		this.switchSituation = switchSituation;
	}
	

	public Animals copy() {
		
		return null;
		
	}
	
	public Animals(int cPopulation, double bRate, double dRate) {
		this.cPopulation = cPopulation;
		this.bRate = bRate;
		this.dRate = dRate;
	}


	

	public double getbRate() {
		return bRate;
	}

	public double getdRate() {
		return dRate;
	}


	public double getInsRate() {
		return insRate;
	}

	public double getCapEfficiency() {
		return capEfficiency;
	}


	public double getAlpha() {
		return alpha;
	}



	public double getBeta() {
		return beta;
	}


	public int getSwitchSituation() {
		return switchSituation;
	}

	public int getcPopulation() {
		return cPopulation;
	}

	public void setcPopulation(int number) {
		if(number < 0) {
			this.cPopulation = 0;
		} else {
		this.cPopulation = number;
		}
	}


	public int getcarrCap() {
		return carrCap;
	}
	
	public void setcarrCap(int number) {
		this.carrCap = number;
	}
	
	
	
	
}
