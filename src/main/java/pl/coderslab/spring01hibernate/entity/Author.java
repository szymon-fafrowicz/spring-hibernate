package pl.coderslab.spring01hibernate.entity;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    @NotBlank
    private String firstName;
    @Column(length = 20)
    @NotBlank
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    @PESEL
    private String pesel;
    @Email
    @NotBlank
    private String email;

    public String getPesel() {
        return pesel;
    }

    public String getEmail() {
        return email;
    }

    public Author setPesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public Author setEmail(String email) {
        this.email = email;
        return this;
    }

    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Author() {
    }

    public Author setId(long id) {
        this.id = id;
        return this;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
