package com.springapp.mvc.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Logitech on 17.06.15.
 */
public class BCryptGeneratorRunner {
public static void main(String[] a){

    String password = "123456";
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(password);
    System.out.print(encodedPassword);}
}
