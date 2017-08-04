package com.tecforce.theater.services.SecurityServices;

import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    @Users
    private DataServiceInterface userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = (User) userService.getById(Long.valueOf(s));
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("Admin"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                roles);
    }
}
