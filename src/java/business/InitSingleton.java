package business;

import entities.Book;
import entities.Category;
import entities.Address;
import entities.Memb;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karácsonyi Gábor
 */
@Startup
@Singleton
public class InitSingleton {
    
    @Resource
    private SessionContext ctx;
    
    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    private void init(){
        ctx.getBusinessObject(InitSingleton.class).initDB();
    }
    
    @Asynchronous
    public void initDB(){
        
        Category novel = new Category("novel");
        Category biology = new Category("biology");
        Category computers = new Category("computers");
        Category physics = new Category("physics");
        
        Book b1 = new Book("Programming", "John Jackson", computers, 4);
        Book b2 = new Book("Az arany ember", "Jokai Mor", novel, 8);
        Book b3 = new Book("Beginning Java EE", "Santiago Ramos", computers, 2);
        Book b4 = new Book("Wildlife","Mark Markson",biology,4);
        Book b5 = new Book("Atom","Alan Robson",physics,3);
        Book b6 = new Book("The Gate","Charles Wilson",novel,2);
        Book b7 = new Book("A lathatatlan ember","Jokai Mor",novel,3);
        
        Address a1 = new Address("1062","Budapest","Kossuth u.1");
        Address a2 = new Address("1011","Budapest","Arany u. 12.");
        Address a3 = new Address("1099","Budapest","Fő tér 3.");
        
        Memb bela = new Memb("Kovacs Bela", a1);
        Memb ferenc = new Memb("Horvath Ferenc",a2);
        Memb tibor = new Memb("Toth Tibor",a3);
        
        
        em.persist(novel);
        em.persist(biology);
        em.persist(computers);
        em.persist(physics);
        
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(b4);
        em.persist(b5);
        em.persist(b6);
        em.persist(b7);
        
        
        em.persist(a1);
        em.persist(a2);
        em.persist(a3);
        
        em.persist(bela);
        em.persist(ferenc);
        em.persist(tibor);
        
        
    }
    
}
