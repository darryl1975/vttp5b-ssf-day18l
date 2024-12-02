package sg.edu.nus.iss.vttp5b_ssf_day18l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5b_ssf_day18l.model.Person;
import sg.edu.nus.iss.vttp5b_ssf_day18l.service.PersonService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping("")
    public String create(Model model) {
        Person p = new Person();

        model.addAttribute("person", p);
        return "personcreate";
    }

    @PostMapping("")
    public String postCreate(@Valid @ModelAttribute("person") Person entity, BindingResult result) {

        if (result.hasErrors())
            return "personcreate";

        personService.createPerson(entity);

        return "redirect:/persons/listing";
    }

    @GetMapping("/listing")
    public String personlisting(Model model) {
        List<Person> persons = personService.getPersons("persons");
        model.addAttribute("persons", persons);
        
        return "personlisting";
    }
    
    
    
}
