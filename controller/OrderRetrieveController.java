package com.railApplication.controller;


import com.railApplication.Entity.User;
import com.railApplication.Repo.UserDetailsRepo;
import com.railApplication.Service.OrderRetrieveService;
import com.railApplication.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/retrieveOrder")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderRetrieveController {

    @Autowired
    private OrderRetrieveService orderRetrieveService;

    @Autowired
    private UserDetailsRepo userRepo;

    @GetMapping("/retrieve/{pnr}")
    public ResponseEntity<List<Passenger>> getOrderDetails(@PathVariable String pnr){
        List<Passenger> list;
         list = orderRetrieveService.fetchOrderDetails(pnr);
         if(list.size() == 0){
             return new ResponseEntity<List<Passenger>>(list,HttpStatus.BAD_REQUEST);
         }
         else
         {
             return new ResponseEntity<List<Passenger>>(list,HttpStatus.OK);
         }
    }

    //Public API, greets the user if user is found in data source.
    @GetMapping("/checker/{username}")
    public ResponseEntity<String> wish(@PathVariable String username){
        User user = userRepo.findByUsername(username);
        if(user != null)
            return new ResponseEntity<String>("Hi "+ username, HttpStatus.OK);
        else
            return new ResponseEntity<String>("User not found!", HttpStatus.BAD_REQUEST);
    }






}
