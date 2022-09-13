/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aguillen.tournamentapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguillen.tournamentapp.dto.AuthDTO;

/**
 *
 * @author Abel Guillen
 */
@RestController
@RequestMapping
public class AuthenticationController {
    
    @GetMapping("/login")
    public AuthDTO authenticate() {
    	if(true)
    		return new AuthDTO(1, "Fulano", "pass", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEiIuHTQeoR4yI-LPCcMeyfixq88YWUgUeag&usqp=CAU");
    	else 
    		return new AuthDTO();
    }
    
}
