package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

import java.util.List;

@Controller
public class ViewController {

    private final PersonRepository personRepository;

    public ViewController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/view")
    public String afficherMots(Model model) {
        model.addAttribute("message", "Coucou c'est le jour 2 !!!!");
        model.addAttribute("mots", List.of("ça me saoule grave", "Olivier", "Toulon", "Adeline", "Blabla"));
        model.addAttribute("formData", new FormData());
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "view";
    }

    @PostMapping("/view")
    public String handleForm(@Valid @ModelAttribute("formData") FormData formData,
                             BindingResult errors,
                             Model model) {
        // Ré-alimente le modèle
        model.addAttribute("message", "Coucou c'est le jour 2 !!!!");
        model.addAttribute("mots", List.of("ça me saoule grave", "Olivier", "Toulon", "Adeline", "Blabla"));

        if (errors.hasErrors()) {
            return "view";
        }

        Person existingPerson = new Person(formData.getWelcome(), formData.getAge());
        personRepository.save(existingPerson);

        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);

        model.addAttribute("welcomeMsg",
                "Bienvenue, " + formData.getWelcome() + " ! Tu as " + formData.getAge() + " ans.");
        return "view";
    }
}