package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.model.VendedorDao;
import fatec.pweb.model.Vendedor;

public class VendedorService {
	VendedorDao vendedorDao = new VendedorDao();
	
	public Vendedor salvar(Vendedor vendedor) {
		vendedor = vendedorDao.save(vendedor);
		vendedorDao.closeEntityManager();
		return vendedor;
	}
	
	public List<Vendedor> getVendedors() {
		List<Vendedor> list = vendedorDao.getAll(Vendedor.class);
		vendedorDao.closeEntityManager();
		return list;
	}
	
	public void alterar (Vendedor vendedor) {
		vendedorDao.save(vendedor);
		vendedorDao.closeEntityManager();
	}
	
	public void remover (Vendedor vendedor) {
		vendedor = vendedorDao.getById(Vendedor.class, vendedor.getCpf());
		vendedorDao.remove(vendedor);
		vendedorDao.closeEntityManager();
	}
}
