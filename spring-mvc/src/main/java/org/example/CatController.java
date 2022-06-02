package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatController {

    @GetMapping("/cat")
    public String helloCat(@RequestParam(name="name", required=false, defaultValue="Cat") String name, Model model) {
        model.addAttribute("name", name);
        return "cat";
    }

    @GetMapping("/dog")
    public String helloDog(@RequestParam(name="name", required=false, defaultValue="Dog") String name, Model model) {
        model.addAttribute("name", name);
        return "dog";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Cat cat, Model model) {
        model.addAttribute("cat", cat);
        return "result";
    }

}