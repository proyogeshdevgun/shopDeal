package com.yogesh.shoponlinefrontend.dao.temp;

public class UserDAO {
	
	public boolean isValidCredentials(String id, String password){
		
		if(id.equals("yogesh") && password.equals("devgun"))
				{
			return true;
				}
		else{//not required but for readability
			return false;
		}
		
		
	}



}
