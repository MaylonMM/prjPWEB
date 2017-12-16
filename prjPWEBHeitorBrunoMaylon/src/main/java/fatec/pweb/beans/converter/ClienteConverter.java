package fatec.pweb.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Cliente;
import fatec.pweb.service.ClienteService;

@FacesConverter("converterCliente")
public class ClienteConverter implements Converter {
	private ClienteService service = new ClienteService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			for (Cliente c : service.getClientes())
				if (c.getNome().equals(value))
					return c;
		}
		
		return null;
	}
	
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object cliente) {
		if (cliente == null || cliente.equals("")) {
			return null;
		} else {
			return ((Cliente) cliente).getNome();
		}
	}
}
