package ru.projectosnova.springlearnsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.projectosnova.springlearnsecurity.entity.UserAccount;
import ru.projectosnova.springlearnsecurity.repository.UserAccountRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //TODO add roles
        UserAccount user = repo.findById(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found with username: " + username) );
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>()) {
        };
    }

}
