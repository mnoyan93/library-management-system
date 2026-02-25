package com.example.librarymanagementsystem.service.sequrity;

import com.example.librarymanagementsystem.config.UserDetailsService;
import com.example.librarymanagementsystem.model.Users;
import com.example.librarymanagementsystem.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDetailsServiceImpl implements UserDetailsService {
private final UsersService usersService;

    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
     Users users = usersService.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found with username "+ username));
        return new SpringUser(users);//spring  ի  user  ն է ;
    }
}
