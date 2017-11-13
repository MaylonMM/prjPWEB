package fatec.pweb.model;

import java.util.ArrayList;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */
public class Cliente extends Pessoa {
    private double limiteCred;
    private double limiteDisp;
    private ArrayList<Pedido> pedidos;

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        limiteDisp = limiteCred;
        pedidos = new ArrayList<Pedido>();
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
    
    //Teste do Git
    //Outro Teste
}
