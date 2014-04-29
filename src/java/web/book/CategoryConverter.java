package web.book;

import dao.BookDao;
import entities.Category;
import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Karácsonyi Gábor
 */
@FacesConverter("CategoryConverter")
@Model
public class CategoryConverter implements Converter{
    
    @Inject
    BookDao bookdao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return bookdao.findCategoryById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Category) value).getId());
    }

}
