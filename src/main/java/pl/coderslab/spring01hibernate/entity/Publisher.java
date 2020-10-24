package pl.coderslab.spring01hibernate.entity;

import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20)
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "publisher")
    List<Book> books = new ArrayList<>();

    @NIP
    @NotBlank
    private String nip;
    @REGON
    @NotBlank
    private String regon;

    public Publisher setNip(String nip) {
        this.nip = nip;
        return this;
    }

    public Publisher setRegon(String regon) {
        this.regon = regon;
        return this;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public Publisher setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Publisher setId(long id) {
        this.id = id;
        return this;
    }

    public Publisher setName(String name) {
        this.name = name;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
