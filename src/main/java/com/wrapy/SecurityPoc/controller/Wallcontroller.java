package com.wrapy.SecurityPoc.controller;


import com.wrapy.SecurityPoc.models.Wall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Wall")
public class Wallcontroller {

    @PostMapping()
    public int getaArea(@RequestBody List<Wall> l1)
    {
        System.out.println(l1);
        int totalArea=0;
        for(Wall w2:l1){
            totalArea=totalArea+w2.area();
        }
        return totalArea;
    }
}
