package exercise2;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class Candles {

	/**
	 * Calculates how many candles could be on a christmas tree with the given height
	 * A recursive solution
	 * @param h The height of the tree
	 * @return the number of candles, which can hang on the tree
	 */
	public static int Recursive(int h){
		if(h<=0)return 0;
		return RecHelp(h,0);
	}
	
	/**
	 * Recursive help method for Recursive(h), performs the calculation of the candles
	 * @param h The current height of the tree
	 * @param count The current number of candles
	 * @return the number of candles, which can hang on the tree
	 */
	private static int RecHelp(int h, int count){
		if(0==h)return count;
		count= count+(int)Math.pow(3, --h);
		return RecHelp(h,count);
	}
	
	/**
	 * Calculates how many candles could be on a christmas tree with the given height
	 * A iterative solution
	 * @param h The height of the tree
	 * @return the number of candles, which can hang on the tree
	 */
	public static int Iterative(int h){
		if(h<=0)return 0;
		int count = 0;
		for(int c = 0;c<h;c++){
			count += (int)Math.pow(3, c);
		}
		return count;
	}
	
}
