package exercise1;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class BalancedBrackets {

	/**
	 * Checks if a the brackets in a String are balanced.
	 * @param expr The string to test
	 * @return true if the brackets are balanced, false if not
	 */
	public static boolean isBalanced(String expr){
		if(expr==null)return true;
		//Remove every character expected brackets
		expr = expr.replaceAll("[^()]","");
		if(expr=="")return true;
		char[] bracks = expr.toCharArray();
		return bracketsToClose(bracks, 0, 0)==0;
	}
	
	/**
	 * Recursive method testing if the brackets in a char[] are balanced.
	 * @param expr The char-Array to test on
	 * @param openedBrackets number of currently opened brackets
	 * @param startingOffset The position at which the string should be tested
	 * @return the number of opened brackets, zero in best case (=balanced), -1 if a bracket is closed and no one was opened
	 */
	private static int bracketsToClose(char[] expr, int openedBrackets, int startingOffset){
		if(startingOffset==expr.length)return openedBrackets;
		if(expr[startingOffset]==')'){
			if(--openedBrackets<0)return -1;
		}
		else openedBrackets++;
		return bracketsToClose(expr,openedBrackets,startingOffset+1);
	}
}
