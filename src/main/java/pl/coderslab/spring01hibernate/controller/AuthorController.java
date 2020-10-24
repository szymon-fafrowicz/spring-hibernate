package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    AuthorDao authorDao;
    BookDao bookDao;

    @Autowired
    public AuthorController(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("authors")
    public Collection<Author> authors() {
        return this.authorDao.findAll();
    }

    @ModelAttribute("books")
    public Collection<Book> books() {
        return this.bookDao.findAll();
    }


    @GetMapping("/list")
    public String list() {
        return "author/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "author/add-form";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if (result.hasErrors()){
            return "author/add-form";
        }

        authorDao.save(author);
        return "redirect:list";
    }


}
