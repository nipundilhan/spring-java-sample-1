package com.example.springsecurity_jwt.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserOperationDatabaseVirtualService {
	
	public UserTemp findUserByUserNameFromDatabase(String userName) {	
		
		
		String[] permissionsHiranya = {"P_1", "P_2","P_3", "P_4"};
		String[] permissionsAnupama = {"P_1", "P_4"};
		String[] permissionsSahan   = {"P_3"};
		String[] permissionsVibodha = {"P_3"};

			
		List<UserTemp> listUsers = new ArrayList<>();
		
		UserTemp hiranya = new UserTemp(1l,"hiranya","hiranya",11l,permissionsHiranya);
		UserTemp anupama = new UserTemp(2l,"anupama","anupama",12l,permissionsAnupama);
		UserTemp sahan = new UserTemp(3l,"sahan","sahan",20l,permissionsSahan);
		UserTemp vibodha = new UserTemp(4l,"vibodha","vibodha",24l,permissionsVibodha);
		
		listUsers.add(hiranya);	
		listUsers.add(anupama);	
		listUsers.add(sahan);	
		listUsers.add(vibodha);	
		
		UserTemp matchedUser = hiranya;
		
		for (UserTemp usr : listUsers) {
			
			if((userName).equals(usr.getUsername())) {				
				matchedUser =  usr;				
			}
			
		}	
				
		return matchedUser;
			
	}

}
