package elementos;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import util.JPAUtil;


@FacesConverter(value="conversorInstrumento")
public class ConversorInstrumento implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		EntityManager em = JPAUtil.createEntityManager();
		if(value == null || value.isEmpty()) return null;
		Integer id = Integer.valueOf(value);
		Instrumento instrumento = em.find(Instrumento.class, id);
		return instrumento;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		
		Instrumento instrumento = (Instrumento) obj;
		if(instrumento == null || instrumento.getId() == null) return null;
		
		return String.valueOf(instrumento.getId());
	}
	
}
