/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgutierrez
 */

@RestController
public class HelloController {
    
    @RequestMapping({"/hello"})
    public String greeting(){
        return "Jefry";
    }
}
