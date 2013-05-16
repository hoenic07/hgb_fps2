package exercise1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class BalancedBracketsTest {

	
	@Test
	public void testBrackets(){
		assertEquals(false,BalancedBrackets.isBalanced("hallo (ich ( bin ( eine ganze)tiefe)aber(wieder)schle)sdad)"));
		assertEquals(false,BalancedBrackets.isBalanced("badass)"));
		assertEquals(false,BalancedBrackets.isBalanced("badass2("));
		
	}
	
	@Test
	public void testValid(){
		assertEquals(true,BalancedBrackets.isBalanced("()()adsd"));
		assertEquals(true,BalancedBrackets.isBalanced("345((345(asdsasd)ads)asd(sd64)asdasd)345"));
		assertEquals(true,BalancedBrackets.isBalanced("()"));
	}
	
	@Test
	public void testEmpty(){
		assertEquals(true,BalancedBrackets.isBalanced(""));
	}
	
	@Test
	public void testNull(){
		assertEquals(true,BalancedBrackets.isBalanced(null));
	}
}
