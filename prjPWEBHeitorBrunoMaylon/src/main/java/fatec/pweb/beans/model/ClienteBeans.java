package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Cliente;
import fatec.pweb.model.Pessoa;
import fatec.pweb.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteBeans {
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	private ClienteService service = new ClienteService();
	
	//Edição de um Cliente na Tabela
	public void onRowEdit(RowEditEvent event) {
		Cliente cli = ((Cliente) event.getObject());
		service.alterar(cli);
	}
	
	public void salvar() {
		if (!Pessoa.validaCPF(cliente.getCpf())){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid CPF",cliente.getCpf()) );
		} else {
			cliente = service.salvar(cliente);
			
			if (clientes != null)
				clientes.add(cliente);
			
			cliente = new Cliente();
		}
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	// Retorna a Lista de Clientes para a Tabela
	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = service.getClientes();
		return clientes;
	}
	
	public void remover(Cliente cliente) {
		service.remover(cliente);
		clientes.remove(cliente);
	}
	
	public Cliente consultar(Cliente cliente) {
		cliente = service.consultar(cliente);
		return cliente;
	}
}
