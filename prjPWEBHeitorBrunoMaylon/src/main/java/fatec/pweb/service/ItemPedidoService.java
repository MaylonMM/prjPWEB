package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.model.ItemPedidoDao;
import fatec.pweb.model.ItemPedido;

public class ItemPedidoService {
	ItemPedidoDao itemDao = new ItemPedidoDao();
	
	public ItemPedido salvar(ItemPedido item) {
		item = itemDao.save(item);
		itemDao.closeEntityManager();
		return item;
	}
	
	public List<ItemPedido> getItens() {
		List<ItemPedido> list = itemDao.getAll(ItemPedido.class);
		itemDao.closeEntityManager();
		return list;
	}
	
	public void alterar(ItemPedido item) {
		itemDao.save(item);
		itemDao.closeEntityManager();
	}
	
	public void remover(ItemPedido item) {
		item = itemDao.getById(ItemPedido.class, item.getNumeroItem());
		itemDao.remove(item);
		itemDao.closeEntityManager();
	}
}
