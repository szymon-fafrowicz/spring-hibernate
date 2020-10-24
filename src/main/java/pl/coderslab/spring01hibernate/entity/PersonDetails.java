package pl.coderslab.spring01hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "personsDetails")
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;

    @OneToOne(mappedBy = "personDetails")
    private Person person;

    public PersonDetails setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public PersonDetails setId(long id) {
        this.id = id;
        return this;
    }

    public PersonDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonDetails setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public PersonDetails setStreet(String street) {
        this.street = street;
        return this;
    }

    public PersonDetails setCity(String city) {
        this.city = city;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetNumber=" + streetNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
