package fatec.pweb.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Vendedor;
import fatec.pweb.service.VendedorService;

@FacesConverter("converterVendedor")
public class VendedorConvertes implements Converter {
	private VendedorService service = new VendedorService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Vendedor v : service.getVendedors())
				 if(v.getNome().equals(value))
				  	return v;
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object vendedor) {
		if (vendedor == null || vendedor.equals("")) {
			return null;
		} else {
			return ((Vendedor) vendedor).getNome();
		}
	}
}
