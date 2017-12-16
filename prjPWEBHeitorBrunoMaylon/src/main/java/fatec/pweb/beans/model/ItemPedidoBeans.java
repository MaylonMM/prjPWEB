package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.ItemPedido;
import fatec.pweb.model.Pedido;
import fatec.pweb.model.Produto;
import fatec.pweb.service.ItemPedidoService;
import fatec.pweb.service.ProdutoService;

@ManagedBean
@ViewScoped
public class ItemPedidoBeans {
	private ItemPedido item = new ItemPedido();
	private List<ItemPedido> itens;
	private ItemPedidoService service = new ItemPedidoService();
	
	private Produto produto;
	private ProdutoService serviceProd = new ProdutoService();
	
	private Pedido pedido;
	
	public void onRowEdit(RowEditEvent event) {
		ItemPedido i = ((ItemPedido) event.getObject());
		service.alterar(i);
	}
	
	public void salvar() {
		item.setProduto(produto);
		item.setPedido(pedido);
		
		item = service.salvar(item);
		
		if (itens != null)
			itens.add(item);
		
		item = new ItemPedido();
		produto = null;
		pedido = null;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}
	
	public List<ItemPedido> getItens() {
		if (itens == null)
			itens = service.getItens();
		return itens;
	}
	
	public void remover(ItemPedido item) {
		service.remover(item);
		itens.remove(item);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		return serviceProd.getProdutos();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
