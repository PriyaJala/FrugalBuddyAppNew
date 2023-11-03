package com.springboot.FrugalBuddyApplication.Controller;

import com.springboot.FrugalBuddyApplication.Dto.LoginDTO;
import com.springboot.FrugalBuddyApplication.Dto.UserDTO;


import com.springboot.FrugalBuddyApplication.Response.LoginResponse;
import com.springboot.FrugalBuddyApplication.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

   @Autowired
    public UserService userService;
    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        System.out.println("-------inside seervice save users------");
        String id= userService.addUser(userDTO);
        System.out.println("id is "+id);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
