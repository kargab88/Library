package service;

import dao.BookDao;
import entities.Book;
import entities.Category;
import entities.Memb;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Karácsonyi Gábor
 */
@Stateless
public class BookService {

    @Inject
    BookDao bookdao;

    public List<Category> getCategories() {
        return bookdao.getCategories();
    }

    public void persist(Book b) {
        bookdao.persist(b);
    }

    public void persistCategory(Category c) {
        bookdao.persistCategory(c);
    }
    
    public List<Book> searchByCriteria(String criteria, String value){
        return bookdao.searchByCriteria(criteria, value);
    }
    
    public Book findById(Long id){
        return bookdao.findById(id);
    }
    
    public void rentBook(Memb m, Book b){
        bookdao.rentBook(m, b);
    }
}
