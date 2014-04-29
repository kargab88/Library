package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
/**
 *
 * @author Karácsonyi Gábor
 */
@Entity
public class Book implements Serializable{
    
    @Id
    @GeneratedValue
    private Long isbn;
    private String title;
    private String author;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private int count;
    private int remain;

    public Book() {
    }

    public Book(String title, String author, Category category, int count) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.count = count;
        remain=count;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    
    
    
    
}
