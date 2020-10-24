package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/bookform")
public class BookFormController {
    AuthorDao authorDao;
    PublisherDao publisherDao;
    BookDao bookDao;

    @Autowired
    public BookFormController(AuthorDao authorDao, PublisherDao publisherDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("books")
    public Collection<Book> books() {
        return this.bookDao.findAll();
    }

    @ModelAttribute("authors")
    public Collection<Author> authors() {
        return this.authorDao.findAll();
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add-form";
    }

    @PostMapping("/add")
    public String addFormPost(@ModelAttribute("book") @Valid Book book, BindingResult result,  Model model) {
        if (result.hasErrors()) {
            return "book/add-form";
        }

        this.bookDao.save(book);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model m, @PathVariable long id) {
        m.addAttribute("book", bookDao.findById(id));
        return "book/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editFormPost(Model m, @ModelAttribute Book book, @PathVariable long id) {
        bookDao.update(book);

        m.addAttribute("book", book);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String bookDelete(@PathVariable long id, Model m) {
        Book book = bookDao.findById(id);
        m.addAttribute("book", book);
        return "book/security";
    }

    @PostMapping("/delete/{id}")
    public String bookDelete(@PathVariable long id, @RequestParam String decision) {
        if ("yes".equals(decision)) {
            bookDao.delete(id);
        }
        return "redirect:../list";
    }


    @GetMapping("/list")
    public String list() {
        return "book/list";
    }

}
