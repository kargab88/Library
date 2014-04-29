package web.book;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Karácsonyi Gábor
 */
@ViewScoped
@Named
public class RenderBook{
    
    private boolean addForm;

    public RenderBook() {
    }
    
    public boolean isAddForm() {
        return addForm;
    }

    public void setAddForm(boolean addForm) {
        this.addForm = addForm;
    }

    public String renderAddForm() {
        addForm = true;
        return null;
    }
    
    public String unRenderAddForm() {
        addForm = false;
        return null;
    }
}