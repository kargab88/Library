package web.search;

import entities.Book;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import service.BookService;

/**
 *
 * @author Karácsonyi Gábor
 */
@Model
public class SearchBean {
    
    @Inject
    BookService bookservice;
    
    private String criteria;
    private String value;
    private List<Book> books;
    private boolean renderForm;

    public SearchBean() {
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean isRenderForm() {
        return renderForm;
    }

    public void setRenderForm(boolean renderForm) {
        this.renderForm = renderForm;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String search(){
        books = bookservice.searchByCriteria(criteria, value);
        if(books.isEmpty())
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No book found!"));
            return null;
        }
        renderForm = true;
        return null;
    } 
}
