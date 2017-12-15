package fatec.pweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */

@Entity
public class ItemPedido {
	
	@Id
    private int numeroItem;
    private int qtdeVendida;
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public void setNumeroItem(int numeroItem) {
		this.numeroItem = numeroItem;
	}

	public int getNumeroItem() {
        return numeroItem;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        pedido.addItem(this);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        produto.setQtdeDisponivel(produto.getQtdeDisponivel() - getQtdeVendida());
    }
    
}