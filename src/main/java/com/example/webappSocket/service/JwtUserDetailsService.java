package com.example.webappSocket.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //check user in database
        if ("admin".equals(username)) {
                return new User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                        Arrays.stream("ROLE_ADMIN".split(","))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}