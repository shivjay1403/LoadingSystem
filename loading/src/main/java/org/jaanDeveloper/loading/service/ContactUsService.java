package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.ContactUs;
import org.jaanDeveloper.loading.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;

    public boolean contactUsGetByAddData(ContactUs contactUs)
    {
        boolean num=false;
      if (contactUs!=null)
      {
        contactUsRepository.save(contactUs);
         num=true;
      }
        return num;
    }
}
