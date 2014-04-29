package web.rent;

import entities.Book;
import entities.Memb;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import service.BookService;
import service.MemberService;
/**
 *
 * @author Karácsonyi Gábor
 */
@SessionScoped
@Named
public class RentBean implements Serializable{
    
    @Inject
    BookService bookservice;
    
    @Inject
    MemberService memberservice;
    
    private Long bookId;
    private Long memberId;
    
    private Book book;
    private Memb member;
    
    private boolean renderForm;

    public RentBean() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Memb getMember() {
        return member;
    }

    public void setMember(Memb member) {
        this.member = member;
    }

    public boolean isRenderForm() {
        return renderForm;
    }

    public void setRenderForm(boolean renderForm) {
        this.renderForm = renderForm;
    }

    public String search(){
        book = bookservice.findById(bookId);
        member = memberservice.findById(memberId);
        if(book==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Book not found!"));
            return null;
        }
        if(member==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Member not found!"));
            return null;
        }
        renderForm = true;
        return null;
    }
    
    public String rentBook(){
        bookservice.rentBook(member, book);
        return null;
    }
}
