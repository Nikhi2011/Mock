package com.cognizant.truyum.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.truyum.model.User;




public class AppUser implements UserDetails{

	private static final long serialVersionUID = 1L;
	private User user; 
	    private Collection<? extends GrantedAuthority> authorities; 

	    public AppUser(User user) {
	    	this.user = user;
	        this.authorities = user.getRoleList().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	    }
	    
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.authorities;
		}
	    
	    public boolean isAccountNonExpired() {
	    	return true;
	    }
	    
	    public boolean isAccountNonLocked() {
	    	return true;
	    }
	    
	    public boolean isCredentialsNonExpired() {
	    	return true;
	    }
	    
	    public boolean isEnabled() {
	    	return true;
	    }


		@Override
		public String getPassword() {
			return  user.getPassword();
		}

		@Override
		public String getUsername() {
			return  user.getUserName();
		}
	    
}
