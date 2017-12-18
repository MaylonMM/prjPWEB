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

import fatec.pweb.model.Vendedor;
import fatec.pweb.service.VendedorService;

@Path("/vendedor")
public class VendedorRest {
	
	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Vendedor findById(@QueryParam("id") String id) {
		VendedorService service = new VendedorService();
		return service.getUserById(id);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vendedor> getAllClientes() {
		List<Vendedor> vendedores;
		VendedorService service = new VendedorService();
		vendedores = service.getVendedors();
		return vendedores;
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Vendedor save(Vendedor vendedor) {
		VendedorService service = new VendedorService();
		return service.salvar(vendedor);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Vendedor vendedor) {
		VendedorService service = new VendedorService();
		service.remover(vendedor);
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Vendedor vendedor) {
		VendedorService service = new VendedorService();
		service.alterar(vendedor);
	}
}
