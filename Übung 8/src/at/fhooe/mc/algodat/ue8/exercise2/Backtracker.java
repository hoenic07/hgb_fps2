package at.fhooe.mc.algodat.ue8.exercise2;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class Backtracker {
	
	public enum Person { anton, berta, clemens, doris};
	
	/**
	 * Defines if a Person of the enum attends the party
	 */
    private boolean[] visitors = new boolean[Person.values().length]; 
    
    /**
     * Print all valid combinations of visitors
     * @param recursive Defines if the next state should be found recursive or iterative
     */
	public void printAllValid(boolean recursive) {
		setStartState();
		do {
			// evaluate candidate
			if (isValid(visitors)) {
				System.out.println("--VISITORS--");
            	for(int i=0;i<visitors.length;i++){
            		if(visitors[i])System.out.println(Person.values()[i]);
            	}
			}
			System.out.println(help++);
		} 
		while (nextState(recursive));
	}
	
	int help=0;
	
	/**
	 * Finds the next next state either recursive or iterative
	 * @param recursive True: recursive, False: iterative
	 * @return true if a valid state was found, otherwise false
	 */
	private boolean nextState(boolean recursive){
		if(recursive)return nextState(0);
		return nextState();
	}

	
	/** Set the first valid state for the visitors[] array */
	private void setStartState() { 
		for(int i=0;i<visitors.length;i++)visitors[i]=false;
	}
	
	/**
	 * Recursive solution to find the next valid state if visitors 
	 * @param level The current level at which the recursion sets the visitor
	 * @return true if a valid state was found, otherwise false
	 */
	private boolean nextState(int level) {
		if(level==visitors.length)return false;
		boolean b = nextState(level+1);
		if(!b)visitors[level]=!visitors[level];
		return visitors[level]?true:b;
	}
	
	/**
	 * Iterative solution to find the next valid state
	 * @return true if a valid state was found, otherwise false
	 */
	private boolean nextState(){
		for(int level=visitors.length-1;level>=0;level--)
			if(visitors[level]=!visitors[level])return true;
		return false;
	}

	/**
     * Checks if the five given conditions are fulfilled
     * @param visitors An array of all visitors, if they attend the party or not
     * @return if the visitor combination is valid or not
     */
    private boolean isValid(boolean[] visitors) {
    	if(visitors!=null&&visitors.length<4)return false;
    	int countTrue=0;
    	
    	//1) at least one visitor
    	int sum=0;
    	for(int i=0;i<visitors.length;i++)if(visitors[i])sum++;
    	if(sum>0)countTrue++;
    	
    	//2) ! (Anton & Doris)
    	if(!(visitors[Person.anton.ordinal()]&&visitors[Person.doris.ordinal()]))countTrue++;
    			
    	//3) if berta -> clemens
    	if(visitors[Person.berta.ordinal()]&&visitors[Person.clemens.ordinal()])countTrue++;
    	// if !berta
    	else if(!visitors[Person.berta.ordinal()])countTrue++;
    	
    	//4) !((anton & clemens) & berta)
    	if(!((visitors[Person.anton.ordinal()]&&visitors[Person.clemens.ordinal()])&&visitors[Person.berta.ordinal()])){
    		countTrue++;
    	}
    	
    	//5) if !anton -> Clemens | doris
    	if(!visitors[Person.anton.ordinal()]&&(visitors[Person.clemens.ordinal()]||visitors[Person.doris.ordinal()])){
    		countTrue++;
    	}
    	// if anton
    	else if(visitors[Person.anton.ordinal()])countTrue++;
    	
    	return countTrue==5;
    }
}
