package pl.coderslab.spring01hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;

public class BookConverter implements Converter<String, Book> {
    @Autowired
    BookDao bookDao;

    @Override
    public Book convert(String authorId) {
        return bookDao.findById(Long.parseLong(authorId));
    }
}
