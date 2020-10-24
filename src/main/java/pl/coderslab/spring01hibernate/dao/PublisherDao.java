package pl.coderslab.spring01hibernate.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager em;

    public List<Publisher> findAll() {
        Query q = em.createQuery("SELECT p FROM Publisher p");
        return q.getResultList();
    }

    public void save(Publisher publisher) {
        em.persist(publisher);
    }

    public void update(Publisher publisher) {
        em.merge(publisher);
    }

    public Publisher findById(long publisherId) {
        return em.find(Publisher.class, publisherId);
    }

    public void delete(long publisherId) {
        Publisher publisher = findById(publisherId);
        em.remove(em.contains(publisher) ?
                publisher : em.merge(publisher));
    }

    public void readBooks(Publisher p) {
        Hibernate.initialize(p.getBooks());
    }
}
