/**
* When the size of data is small (< 9) call the insertion sort
* else call the quick sort
*/
public class QuickSort_InsertionSort_Combo {
	public static void sort(int[] arr, int start, int end) {
		if(start < end) {
      // call insertion sort
			if ((end - start) < 9) {
				insertionSort(arr, start, end);
			}
      
      // call quick sort
			else {
				int pivot_pos;
				pivot_pos = partition(arr, start, end);
				sort(arr, start, pivot_pos - 1);
				sort(arr, pivot_pos + 1, end);
			}
		}
	}
	
	public static void insertionSort(int[] arr, int start, int end) {
		for(int i = start; i <= end; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1])
					swap(arr, j, j-1);
				else
					break;
			}
		}
	}
	
	public static int partition(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int pivot, lastSmall;
		swap(arr, mid, low);
		pivot = arr[low];
		lastSmall = low;
		
		for(int i = low + 1; i <= high; i++) {
			if(arr[i] < pivot) {
				swap(arr, ++lastSmall, i);
			}
		}
		
		swap(arr, low, lastSmall);
		return lastSmall;
	}
	
	public static void swap(int[] arr, int n, int m) {
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	
	public static void printArray(int[] arr, int length) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {14, 3, 56, 7, 89, 0, 234, 564, 11};
		int start = 0;
		int end = arr.length - 1;
		
		printArray(arr, arr.length);
		sort(arr, start, end);
		printArray(arr, arr.length);
		
	}
}


