package at.fhooe.mc.algodat.ue8;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;


/**
 * 
 * @author Niklas Hoesl
 *
 */
public class MergesortTest {

	@Test
	public void testIntegerRevertArray(){
		Sorter<Integer> sorter = new Mergesort<Integer>();
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
		Sorter<String> sorter = new Mergesort<String>();
		String[] result = {"a","b","c","c","e","f"};
		String[] a = new String[result.length];
		for(int i=0;i<result.length;i++){
			a[i]=result[result.length-i-1];
		}
		sorter.sort(a);
		assertArrayEquals(result, a);
	}
	
	@Test
	public void testInteger(){
		int times=10;
		int[] lengths ={100,1000,10000};
		int[] res = new int[lengths.length];
		int[] resQ = new int[lengths.length];
		
		Sorter<Integer> sortM = new Mergesort<Integer>();
		Sorter<Integer> sortQ = new Quicksort<Integer>();
		for(int i=0;i<lengths.length*times;i++){
			res[i%lengths.length]+=testByLength(lengths[i%lengths.length],sortM);
			resQ[i%lengths.length]+=testByLength(lengths[i%lengths.length],sortQ);
		}
		System.out.println("Integer-Vergleich");
		for(int i=0;i<lengths.length;i++){
			System.out.println("Mergesort: Size: "+lengths[i]+", Duration: "+(res[i]/times/1000)+" µ-Seconds");
			System.out.println("Quicksort: Size: "+lengths[i]+", Duration: "+(resQ[i]/times/1000)+" µ-Seconds");
		}
		
	}
	
	@Test
	public void testStrings(){
		int times=10;
		int[] lengths ={100,1000,10000};
		int[] res = new int[lengths.length];
		int[] resQ = new int[lengths.length];
		Sorter<String> sortM = new Mergesort<String>();
		Sorter<String> sortQ = new Quicksort<String>();
		for(int i=0;i<lengths.length*times;i++){
			res[i%lengths.length]+=testByLengthString(lengths[i%lengths.length],sortM);
			resQ[i%lengths.length]+=testByLengthString(lengths[i%lengths.length],sortQ);
		}
		System.out.println("String-Vergleich");
		for(int i=0;i<lengths.length;i++){
			System.out.println("Mergesort: Size: "+lengths[i]+", Duration: "+(res[i]/times/1000)+" µ-Seconds");
			System.out.println("Quicksort: Size: "+lengths[i]+", Duration: "+(resQ[i]/times/1000)+" µ-Seconds");
		}
		
	}
	
	public long testByLength(int l,Sorter<Integer> sorter){
		Integer[] a = new Integer[l];
		Integer[] result = new Integer[l];
		for(int i=0;i<l;i++){
			a[i]=new Integer(l-i);
			result[i]=i+1;
		}
		long beg = System.nanoTime();
		sorter.sort(a);
		long res = (System.nanoTime()-beg);
		
		assertArrayEquals(result, a);
		return res;
	}
	
	public long testByLengthString(int l,Sorter<String> sorter){
		String[] a = new String[l];
		String[] strings = {"aorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut", 
							"babore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo saddd",
							"cebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Loressdd",
							"dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et eeew",
							"eiam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,"};
		String[] result = new String[l];
		for(int i=0;i<l;i++){
			a[i]=strings[i%5];
		}
		int j=0;
		for(int i=0;i<l;i++){
			if(i%(l/5)==0&&i!=0)j++;
			result[i]=a[j];
		}
		long beg = System.nanoTime();
		sorter.sort(a);
		long res = (System.nanoTime()-beg);
		
		assertArrayEquals(result, a);
		return res;
	}
	
}
