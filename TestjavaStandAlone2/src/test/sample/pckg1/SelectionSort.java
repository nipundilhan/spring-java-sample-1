package test.sample.pckg1;

public class SelectionSort {

	
	public static void main(String args[]) {
		
		SelectionSort ss = new SelectionSort();
		
		int arr[] = { 10,20,12,24,8,4,21, 16};
		
		for(int i = arr.length-1; i > 1 ; i--) {
			int maxIndex = i;
			int max = arr[i];
			for(int j = i-1;j>-1;j--) {
				if(max<arr[j]) {
					maxIndex = j;
					max = arr[j];
				}
			}
			
			int temp = arr[i];
			arr[i] = max;
			arr[maxIndex] =  temp;
					
		}
		
		ss.printArray(arr);
		
	}
	
	public void printArray(int dblarray[]) {
		for(int i =0 ; i <dblarray.length ;i++ ) {
			System.out.print(dblarray[i]+"  ");
		}
		System.out.println("");
	}
}
