package service;

import dao.MemberDao;
import entities.Address;
import entities.Memb;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Karácsonyi Gábor
 */
@Stateless
public class MemberService {
    
    @Inject
    MemberDao memberdao;
    
    public void register(Memb m,Address a){
        memberdao.register(m,a);
    }
}
