package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.model.ProdutoDao;
import fatec.pweb.model.Produto;

public class ProdutoService {
	ProdutoDao produtoDao = new ProdutoDao();
	
	public Produto salvar(Produto produto) {
		produto = produtoDao.save(produto);
		produtoDao.closeEntityManager();
		return produto;
	}
	
	public List<Produto> getProdutos() {
		List<Produto> list = produtoDao.getAll(Produto.class);
		produtoDao.closeEntityManager();
		return list;
	}
	
	public void alterar(Produto produto) {
		produtoDao.save(produto);
		produtoDao.closeEntityManager();
	}
	
	public void remover(Produto produto) {
		produto = produtoDao.getById(Produto.class, produto.getCodigo());
		produtoDao.remove(produto);
		produtoDao.closeEntityManager();
	}
	
	public Produto getProdById(int id) {
		return produtoDao.getById(Produto.class, id);
	}
}
