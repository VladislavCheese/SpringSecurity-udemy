package org.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {
    @GetMapping("/")
    public String getInfoForAllPeople(){
        return "/info";
    }
    @GetMapping("/manager_info")
    public String getInfoOnlyForManagers(){
        return "/manager_view";
    }
    @GetMapping("/owner_info")
    public String getInfoOnlyForOwners(){
        return "/owner_view";
    }
}
