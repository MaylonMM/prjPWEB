package fatec.pweb.model;

import java.util.ArrayList;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */

public class Vendedor extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private double salarioBase;
    private double comissao;
    private ArrayList<Pedido> pedidos;

    public Vendedor(String cpf, String nome, double salarioBase) {
    	super.setCpf(cpf);
        super.setNome(nome);
        this.salarioBase = salarioBase;
        pedidos = new ArrayList<Pedido>();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public void addPedido(Pedido ped) {
        pedidos.add(ped);
        ped.setVendedor(this);
    }
    
}