package at.fhooe.mc.algodat.ue8;


/**
 * 
 * @author Niklas Hoesl
 *
 * @param <T> Type of the data to sort
 */
public class Mergesort<T> implements Sorter<T> {
	
	@Override
	public void sort(Comparable<T>[] a) {
		Comparable<T>[] b = sortRec(a);
		for(int i=0;i<a.length;i++)a[i]=b[i];
	}
	
	/**
	 * Sorts a given array with mergesort recursive
	 * @param a array to sort
	 * @return a sorted array
	 */
	private Comparable<T>[] sortRec(Comparable<T>[] a){
		if(a.length>1){
			Comparable<T>[] left=sortRec(subarray(a,0,a.length/2));
			Comparable<T>[] right=sortRec(subarray(a,a.length/2,a.length));
			a= merge(left,right);
		}
		return a;
	}
	
	/**
	 * Merges two given sorted array, so that the elements in the resulting array are sorted too
	 * @param a The first sorted array
	 * @param b The second sorted array
	 * @return The sorted array containing all elements of a and b (length=a+b)
	 */
	private Comparable<T>[] merge(Comparable<T>[] a,Comparable<T>[] b){
		Comparable<T>[] t = (Comparable<T>[])new Comparable[a.length+b.length];
		int i=0,j=0,tC=0;
		while(i<a.length||j<b.length){
			boolean aEnd=i==a.length;
			boolean bEnd=j==b.length;
			if(!aEnd&&(bEnd||a[i].compareTo((T)b[j])<0)){
				t[tC++]=a[i++];
			}
			else if(!bEnd&&(aEnd||b[j].compareTo((T)a[i])<0)){
				t[tC++]=b[j++];
			}
			else{
				int l = b[j].compareTo((T)a[i]);
				if(!aEnd)t[tC++]=a[i++];
				if(!bEnd)t[tC++]=b[j++];
			}
		}
		return t;
	}
	
	/**
	 * Creates an array of a set of elements of the given array, starting at index start, to exclusive end
	 * @param a Array to generate the sub array from
	 * @param start Inclusive Start-Index of the sub array
	 * @param end Exclusive end-index of the sub array
	 * @return sub array of the given array
	 */
	private Comparable<T>[] subarray(Comparable<T>[] a, int start, int end){
		Comparable<T>[] result = (Comparable<T>[])new Comparable[end-start];
		for(int i=start;i<end;i++)result[i-start]=a[i];
		return result;
	}

}
