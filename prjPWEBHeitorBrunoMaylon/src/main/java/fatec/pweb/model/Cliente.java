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
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private double limiteCred;
    private double limiteDisp;
    @OneToMany(mappedBy="cliente")
    private ArrayList<Pedido> pedidos;

    public Cliente() {
        pedidos = new ArrayList<Pedido>();
        
    }

	public void setLimiteCred(double limiteCred) {
		this.limiteCred = limiteCred;
		limiteDisp = limiteCred;
	}

	public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }

    public void addPedido(Pedido ped) {
        pedidos.add(ped);
        ped.setCliente(this);
    }
    
}
