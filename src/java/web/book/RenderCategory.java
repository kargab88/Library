package web.book;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Karácsonyi Gábor
 */
@ViewScoped
@Named
public class RenderCategory{
    
    private boolean categoryForm;

    public RenderCategory() {
    }
    
    public boolean isCategoryForm() {
        return categoryForm;
    }

    public void setCategoryForm(boolean categoryForm) {
        this.categoryForm = categoryForm;
    }
    
    public String renderCategoryForm() {
        categoryForm = true;
        return null;
    }
    
    public String unRenderCategoryForm() {
        categoryForm = false;
        return null;
    }
}