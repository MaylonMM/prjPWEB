package fatec.pweb.webservices;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fatec.pweb.model.Cliente;
import fatec.pweb.service.ClienteService;

@Path("/cliente")
public class ClienteRest {
	
	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente findById(@QueryParam("id") String id) {
		ClienteService service = new ClienteService();
		return service.getUserById(id);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes;
		ClienteService service = new ClienteService();
		clientes = service.getClientes();
		return clientes;
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente save(Cliente cliente) {
		ClienteService service = new ClienteService();
		return service.salvar(cliente);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Cliente cliente) {
		ClienteService service = new ClienteService();
		service.remover(cliente);
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Cliente cliente) {
		ClienteService service = new ClienteService();
		service.alterar(cliente);
	}
}
