package com.wrapy.SecurityPoc.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails{

    private String Username;
    Optional<Users> user;
    private String  email;
    private String  full_name;
    private String password;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(String Username) {
        this.Username=Username;
    }

    public MyUserDetails() {

    }

    public MyUserDetails(Users user) {
        this.Username=user.getUsername();
        this.password=user.getPassword();
        this.full_name=user.getFullName();
        this.email=user.getEmail();
        this.authorities= Arrays.stream(user.getRoles().split(","))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //System.out.println(authorities.toString());
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.Username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
