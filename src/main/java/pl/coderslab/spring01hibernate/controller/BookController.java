package pl.coderslab.spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    BookDao bookDao;
    PublisherDao publisherDao;
    AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    @ResponseBody
    public String add() {
        Book book = new Book()
                .setTitle("Thinking in Java")
                .setDescription("Ciekawa pozycja.")
                .setRating(7);
        bookDao.save(book);

        return "added book id=" + book.getId();
    }

    @GetMapping("/addwp")
    @ResponseBody
    public String addwithPublisher() {
        Publisher publisher = new Publisher()
                .setName("PWN");
        publisherDao.save(publisher);

        Book book = new Book()
                .setTitle("Thinking in C++")
                .setDescription("Interesująca lektura.")
                .setRating(6)
                .setPublisher(publisher);
        bookDao.save(book);

        return "added book id=" + book.getId() + " with publisher id=" + publisher.getId();
    }

    @GetMapping("/addwap")
    @ResponseBody
    public String addwithAandP() {
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(1));
        authors.add(authorDao.findById(2));

        Publisher publisher = publisherDao.findById(1);

        Book book = new Book()
                .setTitle("Thinking in C++")
                .setDescription("Interesująca lektura.")
                .setRating(6)
                .setAuthors(authors)
                .setPublisher(publisher);

        bookDao.save(book);

        return "added book id=" + book.getId() + " with publisher: " + book.getPublisher() + " with authors: " + book.getAuthors();
    }

    @GetMapping("/addwap2")
    @ResponseBody
    public String addwithAandP2() {
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(3));
        authors.add(authorDao.findById(2));

        Publisher publisher = publisherDao.findById(2);

        Book book = new Book()
                .setTitle("Thinking in Python")
                .setDescription("Obowiązkowa lektura.")
                .setRating(8)
                .setAuthors(authors)
                .setPublisher(publisher);

        bookDao.save(book);

        return "added book id=" + book.getId() + " with publisher: " + book.getPublisher() + " with authors: " + book.getAuthors();
    }


    @GetMapping("/all")
    @ResponseBody
    public String findAll() {
        List<Book> books = bookDao.findAll();
        return books.toString();
    }

    @GetMapping("/withanypublisher")
    @ResponseBody
    public String findWithAnyPublisher() {
        List<Book> books = bookDao.findWithAnyPublisher();
        return books.toString();
    }

    @GetMapping("/bypublisher/{publisherId}")
    @ResponseBody
    public String findByPublisher(@PathVariable long publisherId) {
        List<Book> books = bookDao.findWithPublisher(publisherId);
        return books.toString();
    }

    @GetMapping("/byauthor/{authorId}")
    @ResponseBody
    public String findByAuthor(@PathVariable long authorId) {
        Author author = authorDao.findById(authorId);
        List<Book> books = bookDao.findWithAuthor(author);
        return books.toString();
    }


    @GetMapping("/byminrating/{minRating}")
    @ResponseBody
    public String getByMinRating(@PathVariable("minRating") int rating) {
        List<Book> books = bookDao.getRatingList(rating);
        return books.toString();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        Book book = bookDao.findById(id)
                .setTitle("Thinking in Python")
                .setDescription("Ciekawa pozycja.")
                .setRating(9);
        bookDao.update(book);

        return book.toString();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        Book book = bookDao.findById(id);

        return book.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable long id) {
        bookDao.delete(id);
    }


}
