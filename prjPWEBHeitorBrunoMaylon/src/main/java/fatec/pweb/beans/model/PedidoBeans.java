package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Pedido;
import fatec.pweb.service.PedidoService;

@ManagedBean
@ViewScoped
public class PedidoBeans {
	private Pedido pedido = new Pedido();
	private List<Pedido> pedidos;
	private PedidoService service = new PedidoService();
	
	public void onRowEdit(RowEditEvent event) {
		Pedido p = ((Pedido) event.getObject());
		service.alterar(p);
	}
	
	public void salvar() {
		pedido = service.salvar(pedido);
		
		if (pedidos != null)
			pedidos.add(pedido);
		
		pedido = new Pedido();
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
}
