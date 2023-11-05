package org.jaanDeveloper.loading.service;

import jakarta.servlet.http.HttpSession;
import org.jaanDeveloper.loading.model.UserRegister;
import org.jaanDeveloper.loading.repository.UserRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserRegisterServiceImp implements UserRegisterService {
    @Autowired
    private UserRegisterRepository userRegisterRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserRegister saveUserRegister(UserRegister userRegister) {
      String password=  passwordEncoder.encode(userRegister.getPassword());
      userRegister.setPassword(password);
      userRegister.setRole("ROLE_USER");
      UserRegister userRegister1= userRegisterRepository.save(userRegister);
        return userRegister1;
    }

    @Override
    public void removeRegisterSessionMassage() {
        HttpSession session =( (ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    session.removeAttribute("msg");
    }

    @Override
    public void removePassChangeMassage() {
        HttpSession session =( (ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        session.removeAttribute("passChangeMsg");
    }

    @Override
    public void removeUsrNotFoundMsg() {
        HttpSession session =( (ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        session.removeAttribute("usrNotFoundMsg");
    }

}
