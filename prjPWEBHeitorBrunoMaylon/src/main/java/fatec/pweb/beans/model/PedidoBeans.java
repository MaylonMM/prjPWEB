package fatec.pweb.beans.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Cliente;
import fatec.pweb.model.ItemPedido;
import fatec.pweb.model.Pedido;
import fatec.pweb.model.Produto;
import fatec.pweb.model.Vendedor;
import fatec.pweb.service.ClienteService;
import fatec.pweb.service.ItemPedidoService;
import fatec.pweb.service.PedidoService;
import fatec.pweb.service.ProdutoService;
import fatec.pweb.service.VendedorService;

@ManagedBean
@SessionScoped
public class PedidoBeans {
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;
	private PedidoService service = new PedidoService();
	private double valorTotal = 0.00;
	
	private Cliente cliente;
	private ClienteService ServiceCli = new ClienteService();
	
	private Vendedor vendedor;
	private VendedorService ServiceVend = new VendedorService();
	
	private ItemPedido item = new ItemPedido();
	private ItemPedidoService ServiceItem = new ItemPedidoService();
	private List<ItemPedido> itens = new ArrayList<>();
	private ItemPedido itemSelec = new ItemPedido();
	
	private Produto produto = new Produto();
	private ProdutoService serviceProduto = new ProdutoService();
	
	public void onRowEdit(RowEditEvent event) {
		Pedido p = ((Pedido) event.getObject());
		service.alterar(p);
	}
	
	public void salvar() {
		pedido.setCliente(cliente);
		pedido.setVendedor(vendedor);
		
		pedido = service.salvar(pedido);
		
		for (ItemPedido i : itens) {
			i = ServiceItem.salvar(i);
			produto = serviceProduto.salvar(i.getProduto());
		}
		
		cliente = pedido.getCliente();
		cliente.setLimiteDisp(cliente.getLimiteDisp() - valorTotal);
		ServiceCli.alterar(cliente);
		
		if (pedidos != null)
			pedidos.add(pedido);
		
		pedido = new Pedido();
		itens = new ArrayList<>();
		cliente = null;
		vendedor = null;
		valorTotal = 0;
	}
	
	public void addItem() {
		item.setPedido(pedido);
		pedido.addItem(item);
		System.out.println("Ola");
		System.out.println(item.getProduto().getDescricao());
		System.out.println(pedido.getItens().get(pedido.getItens().size() - 1).getProduto().getDescricao());
		valorTotal += item.getQtdeVendida() * item.getProduto().getPrecoUnit();
		valorTotal += 10;
		item = new ItemPedido();
	}
	
	public void removerItem(ItemPedido i) {
		itens.remove(i);
		valorTotal -= i.getQtdeVendida() * i.getProduto().getPrecoUnit();
		retirarItem();
	}
	
	public void alterarItem() {
		itens.remove(itemSelec);
		valorTotal -= itemSelec.getQtdeVendida() * itemSelec.getProduto().getPrecoUnit();
		itemSelec = new ItemPedido();
		
		itens.add(item);
		valorTotal += item.getQtdeVendida() * item.getProduto().getPrecoUnit();
		item = new ItemPedido();
		retirarItem();
	}
	
	public void retirarItem() {
		item = new ItemPedido();
		itemSelec = new ItemPedido();
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
