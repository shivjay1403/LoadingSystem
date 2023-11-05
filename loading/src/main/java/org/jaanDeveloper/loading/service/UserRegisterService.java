package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.UserRegister;

public interface UserRegisterService {
    public UserRegister saveUserRegister(UserRegister userRegister);
    public void removeRegisterSessionMassage();
    public void removePassChangeMassage();
   public void removeUsrNotFoundMsg();
}
