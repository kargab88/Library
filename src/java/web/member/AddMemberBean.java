package web.member;

import entities.Address;
import entities.Memb;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import service.MemberService;

/**
 *
 * @author Karácsonyi Gábor
 */
@Model
public class AddMemberBean {

    @Inject
    MemberService mservice;

    private boolean addForm;

    private String name;
    private String zip;
    private String city;
    private String street;

    public AddMemberBean() {
    }

    public boolean isAddForm() {
        return addForm;
    }

    public void setAddForm(boolean addForm) {
        this.addForm = addForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String renderAddForm() {
        addForm = true;
        return null;
    }

    public String register() {
        Address a = new Address(zip, city, street);
        Memb m = new Memb(name, a);
        mservice.register(m, a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Member successfully created"));
        return null;
    }
    
    public String test1() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("test1"));
        return null;
    }
    
    public String test2() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("test2"));
        return null;
    }
}
