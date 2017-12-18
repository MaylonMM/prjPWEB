package fatec.pweb.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */

@Entity
public class Pedido {
	@Id
    private int numero;
    private String dataEmissaoPedido;
    private String dataPagto;
    private boolean status;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Vendedor vendedor;
    @OneToMany(mappedBy="pedido")
    private ArrayList<ItemPedido> itens;

    public Pedido() {
        itens = new ArrayList<ItemPedido>();
    }
    
    public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemPedido> itens) {
		this.itens = itens;
	}

	public void setDataEmissaoPedido(String dataEmissaoPedido) {
		this.dataEmissaoPedido = dataEmissaoPedido;
	}

	public int getNumero() {
        return numero;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void addItem(ItemPedido item) {
        itens.add(item);
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

	public void setNumero(int numero) {
		this.numero = numero;
	}
    
}