package dao;

import entities.Address;
import entities.Memb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karácsonyi Gábor
 */
@Stateless
public class MemberDao {
    
    @PersistenceContext
    EntityManager em;
    
    public void register(Memb m,Address a){
        em.persist(a);
        em.persist(m);
    }
}
