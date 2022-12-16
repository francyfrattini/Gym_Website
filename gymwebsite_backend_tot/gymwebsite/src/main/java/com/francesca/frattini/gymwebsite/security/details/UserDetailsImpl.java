package com.francesca.frattini.gymwebsite.security.details;

import java.io.Serial;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.francesca.frattini.gymwebsite.entities.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	private final String email;

	private Long id;

	private String username;

	@JsonIgnore
	private String password;

	private boolean accountNonLocked = true;
	private boolean accountNonExpired = false;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	private Date ExpirationTime;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String username, boolean enabled,
						   Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountNonLocked = enabled;
		this.accountNonExpired = enabled;
		this.credentialsNonExpired = enabled;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Utente utente) {
		List<GrantedAuthority> authorities = utente.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(utente.getUtenteId(), utente.getUsername(), utente.getPassword(),
				utente.getActive(), authorities);
	}

	public Object getEmail() {
		return email;
	}
}
