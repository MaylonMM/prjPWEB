package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.model.ClienteDao;
import fatec.pweb.model.Cliente;

public class ClienteService {
	ClienteDao clienteDao = new ClienteDao();
	
	public Cliente salvar(Cliente cliente) {
		cliente = clienteDao.save(cliente);
		clienteDao.closeEntityManager();
		return cliente;
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> list = clienteDao.getAll(Cliente.class);
		clienteDao.closeEntityManager();
		return list;
	}
	
	public void alterar(Cliente cliente) {
		clienteDao.save(cliente);
		clienteDao.closeEntityManager();
	}
	
	public void remover(Cliente cliente) {
		cliente = clienteDao.getById(Cliente.class, cliente.getCpf());
		clienteDao.remove(cliente);
		clienteDao.closeEntityManager();
	}
	
	public Cliente consultar(Cliente cliente) {
		cliente = clienteDao.getById(Cliente.class, cliente.getCpf());
		clienteDao.closeEntityManager();
		return cliente;
	}
	
	public Cliente getUserById(String id) {
		return clienteDao.getById(Cliente.class, id);
	}
}