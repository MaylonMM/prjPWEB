package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.ItemPedido;
import fatec.pweb.service.ItemPedidoService;

@ManagedBean
@ViewScoped
public class ItemPedidoBeans {
	private ItemPedido item = new ItemPedido();
	private List<ItemPedido> itens;
	private ItemPedidoService service = new ItemPedidoService();
	
	public void onRowEdit(RowEditEvent event) {
		ItemPedido i = ((ItemPedido) event.getObject());
		service.alterar(i);
	}
	
	public void salvar() {
		item = service.salvar(item);
		
		if (itens != null)
			itens.add(item);
		
		item = new ItemPedido();
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
}
