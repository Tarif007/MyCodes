package model;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class NaturePreserve {
	  private ArrayList<Animals> animalsPop = new ArrayList<Animals>();
	  private static NaturePreserve natPres= null; 
	  private ArrayList<Animals> originState = new ArrayList<Animals>();
	  private ArrayList<DataSamp> yearlyData = new ArrayList<DataSamp>();
	 
	   

      private NaturePreserve () { 
	    	int popCow = 200;
	    	int PopHorse = 990;
	    	this.animalsPop.add(new Cows( 200 , 510, PopHorse));
	    	this.animalsPop.add(new Horses( 990 ,1000, popCow));
	    	this.animalsPop.add(new Deers( 2500 , 2300));
	    	this.animalsPop.add(new Wolves(0, 0.6, 0.4));
	  
	    	this.originState.add(0, new Cows( 200 , 510, PopHorse));
	    	this.originState.add(1, new Horses( 990 ,1000, popCow));
	    	this.originState.add(2, new Deers( 2500 , 2300));
	    	this.originState.add(3, new Wolves(0, 0.6, 0.4));
	       
	    } 
	    
	    public void reset() {
	    
	    	int popCow = 200;
	    	int PopHorse = 990;
	    	this.animalsPop.add(0, originState.get(0).copy());
	    	this.animalsPop.add(1, originState.get(1).copy());
	    	this.animalsPop.add(2, originState.get(2).copy());
	    	this.animalsPop.add(3, originState.get(3).copy());
	  
	    	this.yearlyData.removeAll(yearlyData);
	    	
	    	 }
	    
	    
	    public void fullReset() {
		    
	    	int popCow = 200;
	    	int PopHorse = 990;
	    	this.animalsPop.add(0, new Cows( 200 , 510, PopHorse));
	    	this.animalsPop.add(1, new Horses( 990 ,1000, popCow));
	    	this.animalsPop.add(2, new Deers( 2500 , 2300));
	    	this.animalsPop.add(3, new Wolves(0, 0.6, 0.4));
	    	
	    	this.originState.add(0, new Cows( 200 , 510, PopHorse));
	    	this.originState.add(1, new Horses( 990 ,1000, popCow));
	    	this.originState.add(2 ,new Deers( 2500 , 2300));
	    	this.originState.add(3, new Wolves(0, 0.6, 0.4));
	  
	    	this.yearlyData.removeAll(yearlyData);
	    	
	    	 }
	  
	 
	    // static method to create instance of Singleton class 
	    public static NaturePreserve getInstance() 
	    { 
	        if (natPres == null) {
	        	 natPres = new NaturePreserve(); 
	  
	        return natPres;
	        
	    }   else {
	    	  return natPres;
	}
	    }
	    
	    public int getCarringCap (int sit) {
	    	int result = 0;
	    	switch (sit) {
	    	case 0: result = getAnimalsPop().get(0).getcarrCap();
	    	case 1: result = getAnimalsPop().get(1).getcarrCap();
	    	case 2: result = getAnimalsPop().get(2).getcarrCap();
	    	
	    	}
	    	
	    	return result;
	    }
	    
	    public static NaturePreserve getNatPres() {
			return natPres;
		}

		public static void setNatPres(NaturePreserve natPres) {
			NaturePreserve.natPres = natPres;
		}


		public ArrayList<Animals> getAnimalsPop() {
			return animalsPop;
		}

		public void setAnimalsPop(ArrayList<Animals> animalsPop) {
			this.animalsPop = animalsPop;
		}
		
		public void addToData(DataSamp dat) {
			yearlyData.add(dat);
		}
		
		public ArrayList<DataSamp> getList (){
			return this.yearlyData;
		}
		
		  public ArrayList<Animals> getOriginState() {
				return originState;
		}

			public void setOriginState(ArrayList<Animals> originState) {
				this.originState = originState;
		}

}
