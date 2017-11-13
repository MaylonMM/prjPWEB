package fatec.pweb.model;

import java.util.ArrayList;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */
public class Pedido {
    private int numero;
    private String dataEmissaoPedido;
    private String dataPagto;
    private boolean status;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itens;

    public Pedido(int numero, String dataEmissaoPedido) {
        this.numero = numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
        itens = new ArrayList<ItemPedido>();
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
        cliente.addPedido(this);
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
        item.setPedido(this);
        cliente.setLimiteDisp(cliente.getLimiteDisp() - (item.getProduto().getPrecoUnit() * item.getQtdeVendida()));
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        vendedor.addPedido(this);
    }
       
}