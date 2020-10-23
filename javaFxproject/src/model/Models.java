package model;

public class Models {
	
	
	private NaturePreserve nat = NaturePreserve.getInstance();	
	static private int counter = 0;
	static private int counter2 = 0;
	private int currentyearPopCow = nat.getAnimalsPop().get(0).getcPopulation();
	private int currentyearPopHorse = nat.getAnimalsPop().get(1).getcPopulation();

	
	
	public Models() {}
	
	public void resetState() {
		currentyearPopCow = nat.getAnimalsPop().get(0).getcPopulation();
		currentyearPopHorse = nat.getAnimalsPop().get(1).getcPopulation();

	}
	
	//Model predation starts here...
	//Calculating Horse and Cattles growth with competition and predator ...
	
	public int calPopWPred(int anim) {
		
		//Storing values to variables.

		double incRate = nat.getAnimalsPop().get(anim).getInsRate();
		
		int cPop = nat.getAnimalsPop().get(anim).getcPopulation();
	
		int carrCap = nat.getAnimalsPop().get(anim).getcarrCap();
		
		 double albeta = 0; 
		 if(anim == 0) {
				albeta = nat.getAnimalsPop().get(anim).getAlpha();
				
			} else {
				albeta = nat.getAnimalsPop().get(anim).getBeta();
				
			}
		
		double capEff = nat.getAnimalsPop().get(anim).getCapEfficiency();
		int predatorPop = nat.getAnimalsPop().get(3).getcPopulation();
		int result2 = 0;
		
		//Implementing the model here(Predation with Horse and Cattles)
		if (anim == 0) {
			double change = (incRate * cPop);
			double change1 = ((carrCap - cPop - (albeta * currentyearPopHorse))/carrCap );
			double change2 = change * change1 ;
			double change3 = capEff * cPop * predatorPop;
            int result =(int)(change2 - change3);
            
			result2 = nat.getAnimalsPop().get(anim).getcPopulation() + result;
			if (result2<0) {
				result2 = 0;
				nat.getAnimalsPop().get(anim).setcPopulation(result2);
				counter++;
				} 
			else {
			nat.getAnimalsPop().get(anim).setcPopulation(result2);
			counter++;
			
	}
}
		
		else {
		
		double change = (incRate * cPop);
		double change1 = ((carrCap - cPop - (albeta * currentyearPopCow))/carrCap );
        double change2 = change * change1 ;
		double change3 = capEff * cPop * predatorPop;
		int result =(int)(change2 - change3);
		
		result2 = nat.getAnimalsPop().get(anim).getcPopulation() + result;
		if (result2<0) {
			result2 = 0;
			nat.getAnimalsPop().get(anim).setcPopulation(result2);
			counter++;
			
		} 
		
		else {
		nat.getAnimalsPop().get(anim).setcPopulation(result2);
		counter++;
		
	}
}
		
		if (counter % 2 == 0) {
			currentyearPopCow = nat.getAnimalsPop().get(0).getcPopulation();
			currentyearPopHorse = nat.getAnimalsPop().get(1).getcPopulation();
			
		}
		
		
		 return result2;
	}

	
    //Calculating Deer growth with predator...
	
	public int calPopWPredDeer(int anim) {
		
       double incRate = nat.getAnimalsPop().get(anim).getInsRate();
       int cPop = nat.getAnimalsPop().get(anim).getcPopulation();
	   int carrCap = nat.getAnimalsPop().get(anim).getcarrCap();
	   double capEff = nat.getAnimalsPop().get(anim).getCapEfficiency();
	   int predatorPop = nat.getAnimalsPop().get(3).getcPopulation();
	  
	   
	   double change = (incRate * cPop * (1-(cPop/carrCap))) - (capEff * cPop * predatorPop);
	   int result = (int) (nat.getAnimalsPop().get(anim).getcPopulation() + change);
	   if (result<0) {
			result =0;
			nat.getAnimalsPop().get(anim).setcPopulation(result);
			
		} 
	   else {
	   nat.getAnimalsPop().get(anim).setcPopulation(result);
			
}
	   return result;
}
	
	
	//Predator growth model...
	
	public int predatorGrowth(int anim) {
		
		double bRate = nat.getAnimalsPop().get(anim).getbRate();
		int cPop = nat.getAnimalsPop().get(anim).getcPopulation();
		double dRate = nat.getAnimalsPop().get(anim).getdRate();
		
		int change =  (int)(cPop *(bRate - dRate));
		int result = nat.getAnimalsPop().get(anim).getcPopulation() + change;
		
		nat.getAnimalsPop().get(3).setcPopulation(result);
		 
		     return result;
		
	}
	
	
	
	//Model extension starts here...
	//Calculating Deer growth..
	
			
     public int deerWextend(int anim , double input) {
    	 
    	
    	double incRate = nat.getAnimalsPop().get(anim).getInsRate();
        double cPop = nat.getAnimalsPop().get(anim).getcPopulation();
        double carrCap = nat.getAnimalsPop().get(anim).getcarrCap();
    
    	double change = (incRate * cPop );
    	double change2 = (1-(cPop/carrCap));
    	double change3 = (1 + (input/2400));
    	
    	int result = (int)(change * change2 * change3);
        int result2 = nat.getAnimalsPop().get(anim).getcPopulation() + result;
        if (result2<0) {
			result2 =0;
			nat.getAnimalsPop().get(anim).setcPopulation(result2);
			
	} 
        else {
    	nat.getAnimalsPop().get(anim).setcPopulation(result2);
	}
		    return result2;
		
}
     
     
     
     //Calculating Horse and Cattles growth ....
     
     public int extendWcom(int anim , double input) {
    	 
    	 double incRate = nat.getAnimalsPop().get(anim).getInsRate();
 		 int cPop = nat.getAnimalsPop().get(anim).getcPopulation();
 	     int carrCap = nat.getAnimalsPop().get(anim).getcarrCap();
 		
 		 double albeta = 0; 
 		 if(anim == 0) {
 				albeta = nat.getAnimalsPop().get(anim).getAlpha();
 				
 			} else {
 				albeta = nat.getAnimalsPop().get(anim).getBeta();
 				
 		}
 		
 		   int result2 = 0;
 		
 		
 		if (anim == 0) {
 			double change = incRate * cPop;
    	    double change2 = (carrCap * (1+input/2400)-cPop-albeta*currentyearPopHorse);
    	    double change3 = (carrCap*(1 + input/2400));
    	    double change4 = change*change2;
    		int result = (int)(change4/change3);
    		
    		
    		result2 = result + nat.getAnimalsPop().get(anim).getcPopulation();
    		 if (result2<0) {
    				result2 =0;
    				nat.getAnimalsPop().get(anim).setcPopulation(result2);
    				counter2++;
    		 }
    		 else {
    		nat.getAnimalsPop().get(anim).setcPopulation(result2);
 			counter2++;
 			
 	}
 }
 		
 		else {
 		
 			double change = incRate * cPop;
    	    double change2 = (carrCap * (1+input/2400)-cPop-albeta*currentyearPopCow);
    	    double change3 = (carrCap*(1 + input/2400));
    	    double change4 = change*change2;
    		int result = (int)(change4/change3);
    		
    		
    		result2 = result + nat.getAnimalsPop().get(anim).getcPopulation();
    		 if (result2<0) {
 				result2 =0;
 				nat.getAnimalsPop().get(anim).setcPopulation(result2);
 				counter2++;
 			} 
    		 else {
    		nat.getAnimalsPop().get(anim).setcPopulation(result2);
 			counter2++;
 		}
 		
 		if (counter2 % 2 == 0) {
 			currentyearPopCow = nat.getAnimalsPop().get(0).getcPopulation();
 			currentyearPopHorse = nat.getAnimalsPop().get(1).getcPopulation();
 			
 		}
 		
    }

 		 return result2; 	 
   }
}
