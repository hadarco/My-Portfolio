package com.hadarco.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUserDetails implements UserDetails {

	private static final long serialVersionUID = 5155720064139820502L;

	private final Long id;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(Long id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;

		// "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYWRhcmNvIiwiZXhwIjoxNTg1MDgwOTE2LCJpYXQiOjE1ODQ0NzYxMTZ9.unX9Pd_OcHM5d2ELpBU61QzKjLPutZklCQ5NFElEHPoQf6DfckbQoZ5fvdOAV8ImFAdxW-dXnWJr0LePl1Of-g"
//{
//    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYWRhcmNvIiwiZXhwIjoxNTg1MDg3OTMzLCJpYXQiOjE1ODQ0ODMxMzN9.HP171Z3Oup3Tbp-BQx_xTiV_136ln3Cc1CuZ2BQIoqOpdJQYTHR1t6AkyVCkcPP3TOgwG1yDbMcUXg5hqMZXcg"
//}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));

		this.authorities = authorities;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
