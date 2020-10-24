package pl.coderslab.spring01hibernate.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    PublisherDao publisherDao;
    BookDao bookDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @ModelAttribute("books")
    public Collection<Book> books() {
        return this.bookDao.findAll();
    }


    @GetMapping("/list")
    public String list() {
        return "publisher/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add-form";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publisher/add-form";
        }
        publisherDao.save(publisher);
        return "redirect:list";
    }


//    @GetMapping("/update/{id}")
//    @ResponseBody
//    public String update(@PathVariable long id) {
//        Publisher publisher = publisherDao.findById(id)
//                .setName("Emaus");
//
//        publisherDao.update(publisher);
//
//        return publisher.toString();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseBody
//    public String findById(@PathVariable long id) {
//        Publisher publisher = publisherDao.findById(id);
//
//        return publisher.toString();
//    }
//
//    @GetMapping("/books/{publisherId}")
//    @ResponseBody
//    @Transactional
//    public String getBookById(@PathVariable long publisherId) {
//        Publisher p = publisherDao.findById(publisherId);
//        publisherDao.readBooks(p);
//        return p.getBooks().toString();
//    }
//
//    @GetMapping("/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable long id) {
//        publisherDao.delete(id);
//    }


}
