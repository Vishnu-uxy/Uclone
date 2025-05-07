package com.user.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.user.service.Repo.userRepo;
import com.user.service.model.userModel;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private userRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<userModel> Optionaluser=repo.findByUsername(username);
		if(Optionaluser.isEmpty()) {
			throw new RuntimeException("user does not exist");
		}
		userModel user=Optionaluser.get();
		UserDetails userDetails=org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPassword()).
				roles(user.getRole().toArray(new String[0])).
				build();
		return userDetails;
	}
	
	

}
