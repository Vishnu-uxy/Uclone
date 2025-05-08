package com.user.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.service.Repo.UserRepo;
import com.user.service.model.UserModel;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserModel> Optionaluser=repo.findByUsername(username);
		if(Optionaluser.isEmpty()) {
			throw new RuntimeException("user does not exist");
		}
		UserModel user=Optionaluser.get();
		UserDetails userDetails=org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPassword()).
				.authorities(authorities) 
				build();
		return userDetails;
	}
	
	

}
