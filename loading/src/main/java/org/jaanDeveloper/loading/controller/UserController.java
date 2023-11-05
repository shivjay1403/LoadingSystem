package org.jaanDeveloper.loading.controller;

import org.jaanDeveloper.loading.model.ContactUs;
import org.jaanDeveloper.loading.repository.UserRegisterRepository;
import org.jaanDeveloper.loading.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {
    ArrayList<Integer> integerArrayList=new ArrayList<>();
    @Autowired
    private KalyanService kService;
    @Autowired
    private MainService mainService;
    @Autowired
    private MilanService milanService;
    @Autowired
    private RajdhaniService rajdhaniService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private ContactUsService contactUsService;
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserRegisterRepository userRegisterRepository;
    @GetMapping("/profile")
    public String userProfile()
    {
        return "uProfile";
    }

}
