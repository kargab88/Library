package web.book;

import entities.Book;
import entities.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class AddBookBean {

    @Inject
    BookService bookservice;

    private String title;
    private String author;
    private Category category;
    private int count;
    
    private String categoryName;

    private List<Category> categories = new ArrayList<>();

    public AddBookBean() {

    }

    @PostConstruct
    private void init() {
        categories = bookservice.getCategories();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String addBook() {
        Book b = new Book(title, author, category, count);
        bookservice.persist(b);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Book succesfully added!"));
        return null;
    }
    
    public String addCategory(){
        Category c = new Category(categoryName);
        bookservice.persistCategory(c);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Category successfully created"));
        return null;
    }

}
