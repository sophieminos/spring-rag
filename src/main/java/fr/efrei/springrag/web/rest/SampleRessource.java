package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.web.dto.Sample;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleRessource {
    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value){
        return "Hello " + value + "!";
    }

    @GetMapping("/samples/dto/{value}")
    public Sample helloJson(@PathVariable(value = "value", required = false) final String value) {
        return new Sample("Hello " + value + "!");
    }
}