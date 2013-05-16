package at.fhooe.mc.algodat.ue8;

/**
 * 
 * @author Niklas Hoesl
 *
 * @param <T> Type of the data to sort
 */
public interface Sorter<T> {
	
	/**
	 * Sortes a given array
	 * @param Array to sort
	 */
	public void sort(Comparable<T>[] a);

}
