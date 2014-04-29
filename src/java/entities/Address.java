package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Karácsonyi Gábor
 */
@Entity
public class Address implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    private String zip;
    private String city;
    private String street;

    public Address() {
    }
    
    public Address(String zip, String city, String street) {
        this.zip = zip;
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
