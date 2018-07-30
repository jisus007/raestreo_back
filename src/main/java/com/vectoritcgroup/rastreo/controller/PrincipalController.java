package com.vectoritcgroup.rastreo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	
    @RequestMapping({"/inicio", "/", "/index", ""})
    public String redirToList(){
        return "inicio";
    }   
    
} 
