package com.example.feedbackservice.services;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.feedbackservice.models.Role;
import com.example.feedbackservice.models.User;
import com.example.feedbackservice.repositories.UserRepository;

@Component
public class UserService implements UserDetailsService
{

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User myUser = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(),
                mapRolesToAthorities(myUser.getRoles()));
    }

    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles)
    {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                .collect(Collectors.toList());
    }

    public void addUser(User user) throws Exception
    {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            throw new Exception("user exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);
    }
}
