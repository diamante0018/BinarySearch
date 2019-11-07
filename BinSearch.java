package binSearch;
import java.util.Scanner;

/**
 * 
 * This Algorithm sorts the command line input, then proceeds with the binary search ("Jacked from the Internet")
 * The input is take from the command line so user must go over to run configurations -> arguments -> program arguments
 */


public class BinSearch {
	public static void main(String[] args) {
		Integer[] a = new Integer[args.length];	
		Scanner input = new Scanner(System.in);
		boolean sorted;
		
		for (int i=0;i<a.length;i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		
		sorted = isSorted(a);
		
		if (sorted) {
			System.out.println("The array is sorted");
		}
		else {
			System.out.println("The array is not sorted");
			a = sortArray(a);
		}
		
		for (int i=0;i<a.length;i++) {
			System.out.println("The value for a[" + i +"] is " + a[i]);
		}
		
		System.out.println("What number would you like to look for in the array?");
		int b = input.nextInt();
		input.close();
		
		int result = binarySearch(a, 0, a.length - 1, b);
		if(result != -1) System.out.println("The element " + b +" was found at the index " + result);
		else System.out.println("The element was not found");
	}
	
	public static  boolean isSorted(Integer[] b) {
		if (b.length<=1) return true;
		
		for (int l=0;l<b.length-1;l++) {
			if (b[l]>b[l+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static Integer[] sortArray(Integer[] h) {
	        int temp,minptr;
	        for (int k=0;k<h.length;k++) {
	            minptr = k;
	            for (int j=(k+1);j<=h.length-1;j++) {
	                if (h[j]<h[minptr]) minptr = j;
	            }
	            temp = h[k];
	            h[k] = h[minptr];
	            h[minptr] = temp;
	        }
	        return h;
	    }
	
	public static int binarySearch(Integer arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
}


