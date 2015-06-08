package com.springapp.mvc.security.user;



public interface UserDAO {

    User findByUserName(String username);

}
