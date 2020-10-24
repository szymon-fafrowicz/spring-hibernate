package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.PersonDao;
import pl.coderslab.spring01hibernate.dao.PersonDetailsDao;
import pl.coderslab.spring01hibernate.entity.Person;
import pl.coderslab.spring01hibernate.entity.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {
    PersonDao personDao;
    PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/form")
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/form";
    }

    @PostMapping("/form")
    public String personFormPost(@RequestParam String login,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 Model model) {

        Person person = new Person().
                setLogin(login)
                .setEmail(email)
                .setPassword(password);
        personDao.save(person);

        model.addAttribute("person", person);
        return "person/show";
    }

    @GetMapping("/bindform")
    public String personBindForm(Model model) {
        model.addAttribute("person", new Person());
        return "person/bindform";
    }

    @PostMapping("/bindform")
    public String personBindFormPost(@ModelAttribute("person") Person formPerson,
                                     Model model) {
        personDao.save(formPerson);
        model.addAttribute("person", formPerson);
        return "person/show";
    }


    @GetMapping("/add")
    @ResponseBody
    public String add() {
        PersonDetails personDetails = new PersonDetails()
                .setFirstName("Adam")
                .setLastName("Mickiewicz")
                .setCity("Rzym")
                .setStreet("Rynek")
                .setStreetNumber(21);
        personDetailsDao.save(personDetails);

        Person person = new Person()
                .setLogin("Adamm")
                .setEmail("a@gmail.com")
                .setPassword("1234")
                .setPersonDetails(personDetails);

        personDao.save(person);

        return "added person id=" + person.getId();
    }

    @GetMapping("/add2")
    @ResponseBody
    public String add2() {


        Person person = new Person()
                .setLogin("Adaś")
                .setEmail("adas@gmail.com")
                .setPassword("1111")
                .setPersonDetails(personDetailsDao.findById(1));

        personDao.save(person);

        return "added person id=" + person.getId();
    }


    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        Person person = personDao.findById(id)
                .setLogin("Micky")
                .setEmail("micky@gmail.com");

        personDao.update(person);

        return person.toString();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        Person person = personDao.findById(id);

        return person.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable long id) {
        personDao.delete(id);
    }

}
