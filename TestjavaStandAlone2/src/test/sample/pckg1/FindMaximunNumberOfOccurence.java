package test.sample.pckg1;

public class FindMaximunNumberOfOccurence {
	
	/*
	public static void main(String args[]) {
		FindMaximunNumberOfOccurence obj = new FindMaximunNumberOfOccurence();
		
		double dblarray[] = { 34.5, 56.7, 12.6, 98.4, 54.21 , 89.55 ,54.2 ,98.4 ,73.2 , 21.45 , 34.5, 98.4 ,21.45 ,98.4, 9.3 };
				
		dblarray = obj.sort(dblarray);
		//obj.printArray(dblarray);
		
		double currentValue = dblarray[0];int currentCount = 1;
		double currentMaxOccurValue = dblarray[0];int countMax=1 ;
		
		for(int i =1 ; i <dblarray.length ;i++) {			
			if(currentValue == dblarray[i]) {
				currentCount = currentCount+1;				
			}else {
				if(currentCount > countMax) {
					countMax = currentCount;
					currentMaxOccurValue = currentValue;
				}
				currentCount = 1;
				currentValue = dblarray[i];			
			}			
		}
		
		if(currentCount > countMax) {
			countMax = currentCount;
			currentMaxOccurValue = currentValue;
		}
		System.out.println("max occurence value - "+currentMaxOccurValue + " no of occurences - "+ countMax);	
				
	}
	*/
	
	/*
	public static void main(String args[]) {
		FindMaximunNumberOfOccurence obj = new FindMaximunNumberOfOccurence();
		
		double dblarray[] = { 34.5, 56.7, 12.6, 98.4, 54.21 , 89.55 ,54.2 ,98.4 ,73.2 , 21.45 , 34.5, 98.4 ,21.45 ,98.4, 9.3 };

		
		double maxValue = dblarray[0];
		int maxCount = 1;
		
		double currentValue = dblarray[0];
		int currentCount = 1;
		
		for(int i =0 ; i <dblarray.length ;i++ ) {	
			currentValue = dblarray[i];
			currentCount = 1;	
			
			if (currentValue != 0) {
				for (int j = i+1; j < dblarray.length; j++) {
					if (dblarray[j] != 0) {
						if (currentValue == dblarray[j]) {
							dblarray[j] = 0;
							currentCount = currentCount + 1;
						}
					}
				}
				
				if(currentCount >maxCount) {
					maxCount = currentCount;
					maxValue = currentValue;
				}					
			}
		}

		
	
		
		System.out.println("max occurence value - "+maxValue + " no of occurences - "+ maxCount);	
				
	}*/
	
	public static void main(String args[]) {

		double[][] arr = { { 34.5, 56.7, 12.6, 98.4, 54.21 }, 
				           { 89.55, 54.2, 98.4, 73.2, 21.45 },
						   { 34.5, 98.4, 21.45, 98.4, 9.3 }
				         };

		double maxValue = arr[0][0];
		int maxCount = 1;

		double currentValue = arr[0][0];
		int currentCount = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				
				currentValue = arr[i][j];
				currentCount = 1;

				if (currentValue != 0) {
					arr[i][j] = 0;
					
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 5; y++) {
							
							if (arr[x][y] != 0) {
								if (currentValue == arr[x][y]) {
									currentCount = currentCount + 1;
									arr[x][y] =0;
								}
							}
							
						}
					}
				}

				if (currentCount > maxCount) {
					maxCount = currentCount;
					maxValue = currentValue;
				}

			}
		}

		System.out.println("max occurence value - " + maxValue + " no of occurences - " + maxCount);
	}
	
	public double[] sort(double dblarray[]) {
		for(int i =0 ; i <dblarray.length ;i++ ) {		
			for(int j =1 ; j <dblarray.length-i ;j++ ) {
				double val1 = dblarray[j];
				double val2 = dblarray[j-1];
				if(val1<val2) {
					dblarray[j] = val2;
					dblarray[j-1] = val1;
				}				
			}
		}
		
		return dblarray;		
	}
	
	public void printArray(double dblarray[]) {
		for(int i =0 ; i <dblarray.length ;i++ ) {
			System.out.print(dblarray[i]+"  ");
		}
		System.out.println("");
	}
}
