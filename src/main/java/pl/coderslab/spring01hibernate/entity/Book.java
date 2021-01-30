package pl.coderslab.spring01hibernate.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,
            length = 100)
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Column(columnDefinition = "TEXT")
    @Size(max = 600)
    private String description;

    @ManyToOne
    @NotNull(message = "Oh, Dear, this must NOT be null")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    @Min(1)
    private int pages;
    @ManyToOne
    private Category category;


    public Book setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setAuthors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Book setId(long id) {
        this.id = id;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", pages=" + pages +
                ", category=" + category +
                '}';
    }
}
