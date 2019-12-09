/**
 * @author wouterverveer 
 */
package com.novi.DiabloDemoDrop.service;

import com.novi.DiabloDemoDrop.utility.JavaMailUtil;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    // Email confirmation for entering a new User.
    public void sendMailNotify(String email){
        try {
            JavaMailUtil.sendMail(email);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
