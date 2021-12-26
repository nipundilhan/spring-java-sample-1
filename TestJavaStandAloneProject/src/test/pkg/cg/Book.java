package test.pkg.cg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Book{
    private String title;
    private String isbn;
    private String author;
    
    
    

	public Book(String title, String isbn, String author) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	public static void main(String[] args){
    	
    	
    	Book b1 = new Book("a",null,"auth1");
    	Book b2 = new Book("b",null,"auth1");
    	Book b3 = new Book("c",null,"auth2");
    	Book b4 = new Book("d",null,"auth2");
    	
    	
    	List<Book> lb= new ArrayList<>();
    	lb.add(b1);    	lb.add(b2);    	lb.add(b3);    	lb.add(b4);
    	
    	HashMap<String, List<Book>> rs = Book.groupByAuthor(lb);
    	
        for (Map.Entry<String,List<Book>> entry : rs.entrySet()) {
        	
        	System.out.print("auth name = "+entry.getKey());
        	List<Book> values = entry.getValue();
        	for(Book b :values ) {
        		System.out.print(" -> "+b.title);
        	}
        	System.out.println("");
        }
        
    }
    
    public static HashMap<String, List<Book>> groupByAuthor( List<Book> books ){
    	
    	HashMap<String, List<Book>>  h1 = new HashMap<>();
    	Set<String> auth= new HashSet<>();
    	    	
    	for(Book  b :books){   		
    		auth.add(b.author);    		  		
    	}
    	
    	for(String  ath :auth){ 
    		
    		
    		h1.put(ath, new ArrayList<>());
    		
        	for(Book  b :books){   		
        		if((ath).equals(b.author)) {
        			List<Book> list = h1.get(ath);
        			list.add(b);
        		}   		  		
        	}		  		
    	}  	
    	
    	return h1;
        
    }
}