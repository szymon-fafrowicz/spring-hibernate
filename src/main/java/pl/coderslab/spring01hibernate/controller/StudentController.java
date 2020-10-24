package pl.coderslab.spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring01hibernate.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        String[] skills = {"Java", "JS", "C++", "C#"};
        return Arrays.asList(skills);
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @PostMapping("form")
    public String formPost(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "student/show";
    }
}
