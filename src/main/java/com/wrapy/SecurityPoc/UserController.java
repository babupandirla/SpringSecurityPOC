package com.wrapy.SecurityPoc;

import com.wrapy.SecurityPoc.models.UserRepository;
import com.wrapy.SecurityPoc.models.Users;
import com.wrapy.SecurityPoc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    UserRepository userrepository;
    @Autowired
    UserService userService;
    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "hello World";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String Admin(){
        return " i am admin";
    }
    @ResponseBody
    @GetMapping("/Users")
    public List<Users> users(){
        System.out.println("request reached");
        return userrepository.findAll();
    }
    @ResponseBody
    @PutMapping("/Users")
    public List<Users> updateUser(@RequestBody Users user){
        System.out.println("update users");
        userService.updateUser(user);
        return userrepository.findAll();
    }
    @ResponseBody
    @PostMapping("/Register")
    public List<Users> registerUser(@RequestBody Users user){
        System.out.println("add user: "+user.toString());
        userService.addUser(user);
        return userrepository.findAll();
    }
}
