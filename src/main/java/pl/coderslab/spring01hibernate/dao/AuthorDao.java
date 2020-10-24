package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager em;


    public List<Author> findAll() {
        Query q = em.createQuery("SELECT a FROM Author a");
        return q.getResultList();
    }

    public void save(Author author) {
        em.persist(author);
    }

    public void update(Author author) {
        em.merge(author);
    }

    public Author findById(long authorId) {
        return em.find(Author.class, authorId);
    }

    public void delete(long authorId) {
        Author author = findById(authorId);
        em.remove(em.contains(author) ?
                author : em.merge(author));
    }

}
