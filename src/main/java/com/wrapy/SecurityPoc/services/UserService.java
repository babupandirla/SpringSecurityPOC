package com.wrapy.SecurityPoc.services;

import com.wrapy.SecurityPoc.models.UserRepository;
import com.wrapy.SecurityPoc.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userrepo;

    public List<Users> getusers(){
        return userrepo.findAll();
    }
    public List<Users> updateUser(Users user){
        System.out.println(user.getUserId());
        try{
            Users updatingUser= userrepo.findByUserId(user.getUserId());
            updatingUser.setFullName(user.getFullName());
            updatingUser.setEmail(user.getEmail());
            updatingUser.setRoles(user.getRoles());
            updatingUser.setUsername(user.getUsername());
            updatingUser.setPassword(user.getPassword());
            userrepo.save(updatingUser);
        }catch(Error e){
            System.out.println(e.toString());
        }
        return userrepo.findAll();
    }
    public List<Users> addUser(Users user){
        System.out.println("request reached to add new user");
       userrepo.save(user);
        return userrepo.findAll();
    }
}
