package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager em;

    public List<Book> findWithAnyPublisher() {
        Query q = em.createQuery("SELECT b FROM Book b JOIN b.publisher");
        return q.getResultList();
    }

    public List<Book> findWithPublisher(long publisherId) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.publisher.id = :publisherId");
        q.setParameter("publisherId", publisherId);
        return q.getResultList();
    }

    public List<Book> findWithAuthor(Author author) {
        Query q = em.createQuery("SELECT b FROM Book b JOIN FETCH b.authors");
        List<Book> books = q.getResultList();

        return books.stream()
                .filter(b -> b.getAuthors().contains(author))
                .collect(Collectors.toList());
    }

    public List<Book> findAll() {
        Query q = em.createQuery("SELECT b FROM Book b");
        return q.getResultList();
    }

    public List<Book> getRatingList(int rating) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.rating >= :rating");
        q.setParameter("rating", rating);
        return q.getResultList();
    }

    public void save(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public Book findById(long bookId) {
        return em.find(Book.class, bookId);
    }

    public void delete(long bookId) {
        Book book = findById(bookId);
        em.remove(em.contains(book) ?
                book : em.merge(book));
    }

}
