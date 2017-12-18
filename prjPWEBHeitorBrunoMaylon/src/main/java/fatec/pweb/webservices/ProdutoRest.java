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

import fatec.pweb.model.Produto;
import fatec.pweb.service.ProdutoService;

@Path("/produto")
public class ProdutoRest {
	
	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto findById(@QueryParam("id") int id) {
		ProdutoService service = new ProdutoService();
		return service.getProdById(id);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> getAllClientes() {
		List<Produto> produtos;
		ProdutoService service = new ProdutoService();
		produtos = service.getProdutos();
		return produtos;
	}
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto save(Produto produto) {
		ProdutoService service = new ProdutoService();
		return service.salvar(produto);
	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(Produto produto) {
		ProdutoService service = new ProdutoService();
		service.remover(produto);
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(Produto produto) {
		ProdutoService service = new ProdutoService();
		service.alterar(produto);
	}
}
