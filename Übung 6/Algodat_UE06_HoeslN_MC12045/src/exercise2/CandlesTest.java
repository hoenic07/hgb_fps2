package exercise2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class CandlesTest {

	@Test
	public void TestRecursive(){
		int lv = 0;
		for(int i=0;i<20;i++){
			int val =Candles.Recursive(i+1);
			//System.out.println("Candles("+(i+1)+"): "+val);
			assertEquals(lv+(int)Math.pow(3, i),val);
			lv =val;
		}
	}
	
	@Test
	public void TestIterative(){
		int lv = 0;
		for(int i=0;i<20;i++){
			int val =Candles.Iterative(i+1);
			//System.out.println("Candles("+(i+1)+"): "+val);
			assertEquals(lv+(int)Math.pow(3, i),val);
			lv =val;
		}
	}
	
	@Test
	public void TestInvalidInput(){
		assertEquals(0,Candles.Recursive(-100));
		assertEquals(0,Candles.Recursive(0));
		assertEquals(0,Candles.Iterative(-100));
		assertEquals(0,Candles.Iterative(0));
	}
}
