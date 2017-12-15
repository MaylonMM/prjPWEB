package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.model.PedidoDao;
import fatec.pweb.model.Pedido;

public class PedidoService {
	
	PedidoDao pedidoDao = new PedidoDao();
	
	public Pedido salvar(Pedido pedido) {
		pedido = pedidoDao.save(pedido);
		pedidoDao.closeEntityManager();
		return pedido;
	}
	
	public List<Pedido> getPedidos() {
		List<Pedido> list = pedidoDao.getAll(Pedido.class);
		pedidoDao.closeEntityManager();
		return list;
	}
	
	public void alterar(Pedido pedido) {
		pedidoDao.save(pedido);
		pedidoDao.closeEntityManager();
	}
	
	public void remover(Pedido pedido) {
		pedido = pedidoDao.getById(Pedido.class, pedido.getNumero());
		pedidoDao.remove(pedido);
		pedidoDao.closeEntityManager();
	}
}
