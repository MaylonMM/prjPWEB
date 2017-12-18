package fatec.pweb.beans.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import fatec.pweb.model.Produto;
import fatec.pweb.service.ProdutoService;

@ManagedBean
@SessionScoped
public class ProdutoBeans {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	private ProdutoService service = new ProdutoService();
	
	public void onRowEdit(RowEditEvent event) {
		Produto p = ((Produto) event.getObject());
		service.alterar(p);
	}
	
	public void salvar() {
		produto = service.salvar(produto);
		
		if (produtos != null)
			produtos.add(produto);
		
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = service.getProdutos();
		return produtos;
	}
	
	public void remover(Produto produto) {
		service.remover(produto);
		produtos.remove(produto);
	}
}
