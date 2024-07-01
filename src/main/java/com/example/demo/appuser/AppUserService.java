package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND = "user with %s email not found";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND)));
    }
}
