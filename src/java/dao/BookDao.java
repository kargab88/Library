package dao;

import entities.Book;
import entities.Category;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Karácsonyi Gábor
 */
@Stateless
public class BookDao{
    
    @PersistenceContext
    EntityManager em;
    
    public List<Category> getCategories(){
        CriteriaBuilder cb  = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> root = cq.from(Category.class);
        cq.select(root);
        
        return em.createQuery(cq).getResultList();
    }
    
    public void persist(Book b){
        em.persist(b);
    }
    
    public Category findCategoryById(Long id){
        return em.find(Category.class, id);
    }
    
    public void persistCategory(Category c){
        em.persist(c);
    }
    
    public List<Book> searchByCriteria(String criteria, String value){
        if(criteria.equals("Title")){
            TypedQuery<Book> searchQuery = em.createQuery("Select b from Book b WHERE b.title=:title",Book.class);
            searchQuery.setParameter("title", value);
            List<Book> books= searchQuery.getResultList();
            return books;
        }
        if(criteria.equals("Author")){
            TypedQuery<Book> searchQuery = em.createQuery("Select b from Book b WHERE b.author=:author",Book.class);
            searchQuery.setParameter("author", value);
            List<Book> books = searchQuery.getResultList();
            return books;
        }
        if(criteria.equals("Category")){
            TypedQuery<Book> searchQuery = em.createQuery("Select b from Book b WHERE b.category.name = :name",Book.class);
            searchQuery.setParameter("name", value);
            List<Book> books = searchQuery.getResultList();
            return books;
        }
        return Collections.EMPTY_LIST;
    }
}
