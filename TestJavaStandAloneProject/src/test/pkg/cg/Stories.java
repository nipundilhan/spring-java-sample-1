package test.pkg.cg;

public class Stories {
    public static int numberOfArrangements(int numberOfStories) {
    	
		int iterations = (numberOfStories /2);
		
		int small = numberOfStories;
		int large = 0;
		
		if(numberOfStories % 2 == 0) {
			iterations = iterations -1;
		}
		
		int finalAnswer = 0;
		for(int i=0; i < iterations ;i++) {
			large = large+1;
			small = small-2;
			
			
			int uda = Stories.kramaropitha(large+small);
			int totalSL = large+small;
			
			int yata1 = Stories.kramaropitha(large);
			int yata2 = Stories.kramaropitha(small);
			
			int ansIntermediate = uda/(yata1*yata2);
			finalAnswer = finalAnswer+ansIntermediate;
			
		}
       
    	if(numberOfStories % 2 == 0) {    		
    		return finalAnswer+1;
    	}else {
    		if(numberOfStories < 4) {
    			return finalAnswer+1;
    		}else {
    			return finalAnswer+(numberOfStories % 2)+1;
    		}
    	}
        
        
        
    }
    
    private static int  kramaropitha(int n) {
    	int ans = 1;
    	for(int i=1; i < n+1 ;i++) {
    		ans = ans*i;
    	}
    	
    	return ans;
    	
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrangements(10));
    }
}