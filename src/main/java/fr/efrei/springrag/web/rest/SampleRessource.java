package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.web.dto.Sample;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@RestController
@RequestMapping("/samples")
public class SampleRessource {
    private final ConcurrentMap<String, Sample> samples = new ConcurrentHashMap<>();
    private static int id = 1;
    @GetMapping("/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value){
        return "Hello " + value + "!";
    }

    @GetMapping("/dto/{id}")
    public Sample helloJson(@PathVariable(value = "id", required = false) final String id) {
        return samples.get(id);
    }
    @PostMapping("/dto")
    public Sample create(@RequestBody Sample sample) {
        samples.put(String.valueOf(id++), sample);
        return sample;
    }

    @PutMapping("/dto/{id}")
    public Sample update(@PathVariable String id, @RequestBody Sample sample) {
        samples.put(id, sample);
        return sample;
    }

    @PatchMapping("/dto/{id}")
    public Sample partialUpdate(@PathVariable String id, @RequestBody Sample sample) {
        samples.computeIfPresent(id, (k, v) -> new Sample(sample.getValue()));
        return samples.get(id);
    }

    @DeleteMapping("/dto/{id}")
    public String delete(@PathVariable String id) {
        samples.remove(id);
        return "Deleted: " + id;
    }
}