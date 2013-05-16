package at.fhooe.mc.algodat.ue8.exercise2;

import org.junit.Test;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class BacktrackerTest {

	@Test
	public void testOssiRecursive(){
		Backtracker b = new Backtracker();
		System.out.println("-----RECURSIVE-----");
		b.printAllValid(true);
		//Not more to test?!
	}
	
	@Test
	public void testOssiIterative(){
		Backtracker b = new Backtracker();
		System.out.println("-----ITERATIVE-----");
		b.printAllValid(false);
		//Not more to test?!
	}
}
