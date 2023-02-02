package com.wrapy.SecurityPoc.services;

import com.wrapy.SecurityPoc.models.MyUserDetails;
import com.wrapy.SecurityPoc.models.UserRepository;
import com.wrapy.SecurityPoc.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userrepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user= Optional.ofNullable(userrepository.findByUsername(userName));
        user.orElseThrow(()-> new UsernameNotFoundException("Not found:"+userName));
        return user.map(MyUserDetails::new).get();
    }

}
