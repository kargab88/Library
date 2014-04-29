package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Karácsonyi Gábor
 */
@Entity
public class Memb implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Address address;
    
    @ManyToMany
    private List<Book> rentedBooks  = new ArrayList<>();

    public Memb() {
    }

    public Memb(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }
    
    
    
    
    
}
