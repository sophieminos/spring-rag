package fr.efrei.springrag.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleRessource {
    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value){
        return "Hello " + value + "!";
    }

}