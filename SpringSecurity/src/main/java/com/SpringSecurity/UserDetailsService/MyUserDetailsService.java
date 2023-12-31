package com.SpringSecurity.UserDetailsService;



import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


// THIS SECURITY IS USED IF WE ARE USING DATA JPA IN OUR PROJECT.
@Service
public class MyUserDetailsService  implements UserDetailsService{
// UserDetailservice is spring boot provide method for security. WE ARE JUST IMPLEMENTING FOR SECURITY.
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUserName () method called");
		// IMP note
		// LOGIC TO GET USER DATA 
		// userRepo.findByUsername(name)  --> this is way if we have data base but here i don't
		//have data base so i will return one user credentials for practice.
		
		
		return new User("nishchal", "nis@123", Collections.emptyList());  // this collection.emptyList mean user has no role.
	}

}
