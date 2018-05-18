package com.example.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entities.User;

public class UserDetailsRest implements UserDetails {

    public static final String ROLES_PREFIX = "ROLE_";

    private User user;

    public UserDetailsRest(User user) {
        this.user = user;
    }

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles[] = user.getRoles();

        if (roles == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(roles).map(
                role -> (GrantedAuthority) () -> ROLES_PREFIX + role
        ).collect(Collectors.toList());
    }
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
