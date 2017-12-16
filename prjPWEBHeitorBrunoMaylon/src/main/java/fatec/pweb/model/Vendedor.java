package fatec.pweb.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */

@Entity
@PrimaryKeyJoinColumn(name="cpf")
public class Vendedor extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	private double salarioBase;
    private double comissao;
    @OneToMany(mappedBy="vendedor")
    private ArrayList<Pedido> pedidos;

    public Vendedor() {
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
    }
    
}