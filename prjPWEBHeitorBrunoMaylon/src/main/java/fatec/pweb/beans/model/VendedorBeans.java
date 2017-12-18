package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Pessoa;
import fatec.pweb.model.Vendedor;
import fatec.pweb.service.VendedorService;

@ManagedBean
@ViewScoped
public class VendedorBeans {
	private Vendedor vendedor = new Vendedor();
	private List<Vendedor> vendedores;
	private VendedorService service = new VendedorService();
	
	public void onRowEdit(RowEditEvent event) {
		Vendedor v = ((Vendedor) event.getObject());
		service.alterar(v);
	}
	
	public void salvar() {
		if (!Pessoa.validaCPF(vendedor.getCpf())){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid CPF",vendedor.getCpf()) );
		} else {
			vendedor = service.salvar(vendedor);
			
			if (vendedores != null)
				vendedores.add(vendedor);
			
			vendedor = new Vendedor();
		}
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public List<Vendedor> getVendedores() {
		if (vendedores == null)
			vendedores = service.getVendedors();
		return vendedores;
	}
	
	public void remover(Vendedor vendedor) {
		service.remover(vendedor);
		vendedores.remove(vendedor);
	}
}
