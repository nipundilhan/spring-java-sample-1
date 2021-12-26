package test.pkg.cg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hobbies {
    
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    
    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }
    
    public List<String> findAllHobbyists(String hobby) {
    	
    	List<String> users =  new ArrayList<>();
    	
        for (Map.Entry<String,String[]> entry : hobbies.entrySet())
        {
        	
        	String[] values = entry.getValue();
        	for(int i = 0 ; i < values.length ; i++) {
        		if(hobby.equals(values[i])) {
        			users.add(entry.getKey());
        		}
        	}

             
        }
        
        return users;
           
    }
    
    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
    }
}
