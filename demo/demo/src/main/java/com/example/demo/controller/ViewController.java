package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("message", "Bienvenue sur la page view, inscrivez-vous !");
        model.addAttribute("formData", new FormData());
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "view";
    }

    @PostMapping("/view")
    public String handleForm(@Valid @ModelAttribute("formData") FormData formData,
                             BindingResult errors,
                             Model model) {
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

        @PostMapping("/persons/{id}/update")
        public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam int age) {
            personRepository.findById(id).ifPresent(p -> {
                p.setName(name);
                p.setAge(age);
                personRepository.save(p);
        });
        return "redirect:/view";
    }

    @PostMapping("/persons/{id}/delete")
        public String delete(@PathVariable Long id) {
            personRepository.deleteById(id);
            return "redirect:/view";
    }
}