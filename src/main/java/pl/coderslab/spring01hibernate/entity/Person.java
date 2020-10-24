package pl.coderslab.spring01hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 25,
            nullable = false)
    private String login;
    private String password;
    private String email;


    @OneToOne
    private PersonDetails personDetails;

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public Person setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
        return this;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public Person setLogin(String login) {
        this.login = login;
        return this;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
