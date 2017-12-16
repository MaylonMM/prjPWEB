package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Cliente;
import fatec.pweb.model.ItemPedido;
import fatec.pweb.model.Pedido;
import fatec.pweb.model.Vendedor;
import fatec.pweb.service.ClienteService;
import fatec.pweb.service.ItemPedidoService;
import fatec.pweb.service.PedidoService;
import fatec.pweb.service.VendedorService;

@ManagedBean
@ViewScoped
public class PedidoBeans {
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;
	private PedidoService service = new PedidoService();
	
	private Cliente cliente;
	private ClienteService ServiceCli = new ClienteService();
	
	private Vendedor vendedor;
	private VendedorService ServiceVend = new VendedorService();
	
	private ItemPedido item;
	private ItemPedidoService ServiceItem = new ItemPedidoService();
	
	public void onRowEdit(RowEditEvent event) {
		Pedido p = ((Pedido) event.getObject());
		service.alterar(p);
	}
	
	public void salvar() {
		pedido.setCliente(cliente);
		pedido.setVendedor(vendedor);
		
		pedido = service.salvar(pedido);
		
		if (pedidos != null)
			pedidos.add(pedido);
		
		pedido = new Pedido();
		cliente = null;
		vendedor = null;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = service.getPedidos();
		return pedidos;
	}
	
	public void remover(Pedido pedido) {
		service.remover(pedido);
		pedidos.remove(pedido);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		return ServiceCli.getClientes();
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public List<Vendedor> getVendedores() {
		return ServiceVend.getVendedors();
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}
	
	public List<ItemPedido> getItens() {
		return ServiceItem.getItens();
	}
}
