package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager em;

    public void save(Person person) {
        em.persist(person);
    }

    public void update(Person person) {
        em.merge(person);
    }

    public Person findById(long personId) {
        return em.find(Person.class, personId);
    }

    public void delete(long personId) {
        Person person = findById(personId);
        em.remove(em.contains(person) ?
                person : em.merge(person));
    }

}
