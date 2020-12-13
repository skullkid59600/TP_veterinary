package com.veterinary.veterinary.animal;

import com.veterinary.veterinary.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public Iterable<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/id/{animalId}")
    public Optional<Animal> getAnimal(@PathVariable("animalId") int animalId) {
        return animalRepository.findById(animalId);
    }

    @GetMapping("/name/{animalName}")
    public Iterable<Animal> getAnimalsByName(@PathVariable("animalName") String name){
        return animalRepository.findAnimalByNameIsContaining(name);
    }
    @PostMapping()
    public Animal addAnimal(@RequestBody Animal newAnimal){
        return animalRepository.save(newAnimal);
    }
}
