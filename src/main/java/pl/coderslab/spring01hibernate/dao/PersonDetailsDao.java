package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Person;
import pl.coderslab.spring01hibernate.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager em;

    public void save(PersonDetails personDetails) {
        em.persist(personDetails);
    }

    public void update(PersonDetails personDetails) {
        em.merge(personDetails);
    }

    public PersonDetails findById(long personDetailsId) {
        return em.find(PersonDetails.class, personDetailsId);
    }

    public void delete(long personDetailsId) {
        PersonDetails personDetails = findById(personDetailsId);
        em.remove(em.contains(personDetails) ?
                personDetails : em.merge(personDetails));
    }

}
