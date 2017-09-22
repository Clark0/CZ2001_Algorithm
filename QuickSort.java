public class QuickSort {

	public static void quickSort(int[] arr, int n, int m) {
		int pivot_pos;
		if(n >= m)
			return;
		pivot_pos = partition(arr, n, m);
		quickSort(arr, n, pivot_pos-1);
		quickSort(arr, pivot_pos + 1, m);
	}
	
	public static int partition(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		swap(arr, low, mid);
		int pivot = arr[low];
		int lastSmall = low;
		
		
		for(int i = low + 1; i <= high; i++) {
			if(arr[i] <= pivot)
				swap(arr, ++lastSmall, i);
		}
		swap(arr, lastSmall, low);
		return lastSmall;
	}
	
	public static void swap(int[] arr, int n, int m) {
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	
	public static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] arr = {12, 34, 2, 67, 1, 678, 9, 4};
		int start = 0;
		int end = arr.length - 1;
		printArray(arr, arr.length);
		quickSort(arr, start, end);
		printArray(arr, arr.length);
	}
}
