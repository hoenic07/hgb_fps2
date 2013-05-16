package at.fhooe.mc.algodat.ue8;

/**
 * 
 * @author Niklas Hoesl
 *
 * @param <T> Type of the data to sort
 */
public class Quicksort<T> implements Sorter<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		qsort(a, 0, a.length-1);
	}
	
	/**
	 * Sortes the array from start-index 'from' to end-index 'to' 
	 * @param a The data array to sort
	 * @param from Start-index to sort
	 * @param to End-index for sorting
	 */
	private void qsort(Comparable<T>[] a, int from, int to){
		if(from<to){
			Comparable<T> pivot = a[(from+to)/2];
			int i=from;
			int j=to;
			do{
				while(a[i].compareTo((T)pivot)<0)i++;
				while(pivot.compareTo((T)a[j])<0)j--;
				if(i<=j){
					Comparable<T> help=a[i];
					a[i]=a[j];
					a[j]=help;
					i++;
					j--;
				}
			}
			while(i<=j);
			qsort(a,from,j);
			qsort(a,i,to);
		}
	}

}
