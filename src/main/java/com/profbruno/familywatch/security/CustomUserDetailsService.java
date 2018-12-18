package com.profbruno.familywatch.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.profbruno.familywatch.repository.FamilyMemberRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private FamilyMemberRepository users;

    public CustomUserDetailsService(FamilyMemberRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }
}