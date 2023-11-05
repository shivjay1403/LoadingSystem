package org.jaanDeveloper.loading.security;

import org.jaanDeveloper.loading.model.UserRegister;
import org.jaanDeveloper.loading.repository.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserServiceDetail implements UserDetailsService {

    @Autowired
    private UserRegisterRepository userRegisterRepository;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
       UserRegister userRegister= userRegisterRepository.findByUsername(mobile);
       if (userRegister==null)
       {
           throw new UsernameNotFoundException("User Not Found");
       }else {
           return new CustomeUser(userRegister);
       }
    }
}
