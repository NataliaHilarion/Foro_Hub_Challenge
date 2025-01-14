package foro.hub.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evergreen")
public class HelloWorld {

    @GetMapping
    public String helloNata(){
        return "Hola Natis probando ando";
    }


}
