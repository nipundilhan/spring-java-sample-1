package test.pkg.sol;

class Solution {
    public static int reverse(int x) {
    	

        int y = x;
        String fin ="";
        
         
        if(y< 0){
        	y = (-1)*y;
            fin = fin+"-";
        }
        
        if(y== 0) {
        	return 0;
        }else if( y > 2147483647) {
        			  
        	System.out.println("karumeta aawaa");
        	return 0;
        }
        

        
        while(y%10 == 0) {
        	y = y/10;
        }
       
        
        while(y > 10){
        	
            if(y%10 != 0){
                int mod = y%10;
                fin = fin+mod;
                y=(y-mod)/10;         
            }else {
            	 fin = fin+0;
            	y = y/10;
            }  
        }
        
        if(y == 10) {
        	fin = fin+"0"+1;
        }else {
        	fin = fin+y;
        }
        
        
        return  Integer.parseInt(fin);      
    }
    
    public static void main(String args[]) {
    	System.out.println(reverse(2147483647));
    }
}