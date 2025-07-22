package com.beyondsubstance.tracker.security;

import com.beyondsubstance.tracker.model.User;
import com.beyondsubstance.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

// 👇 ADD THIS import explicitly for the Spring Security's User class
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(appUser.getUsername());
        builder.password(appUser.getPassword());
        builder.roles(appUser.getRole());

        return builder.build();
    }
}
