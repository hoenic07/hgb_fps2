package at.fhooe.mc.algodat.ue8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Niklas Hoesl
 *
 */
public class QuicksortTest {

	@Test
	public void testIntegerRevertArray(){
		Sorter<Integer> sorter = new Quicksort<Integer>();
		Integer[] a = new Integer[10];
		Integer[] result = new Integer[10];
		for(int i=0;i<10;i++){
			a[i]=new Integer(10-i);
			result[i]=i+1;
		}
		sorter.sort(a);
		assertArrayEquals(result, a);
	}
	
	@Test
	public void testStringRevertArray(){
		Sorter<String> sorter = new Quicksort<String>();
		String[] result = {"asdf","bsads","cfhgfj","dgsa","edsf","fs"};
		String[] a = new String[result.length];
		for(int i=0;i<result.length;i++){
			a[i]=result[result.length-i-1];
		}
		sorter.sort(a);
		assertArrayEquals(result, a);
	}
}
