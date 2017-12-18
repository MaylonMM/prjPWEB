package fatec.pweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author 0030481611007
 * @author 0030481611020
 * @author 0030481611029
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String cep;
    private String uf;
    private String ddd;
    private String telefone;

    public Pessoa() {
    	
    }
    
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public static boolean validaCPF(String CPF){       
    	CPF = CPF.replace(".", "").replace("-", "");
        int valid = 0;
        String erro = "";
        int numMult, i, result, numCpf;
        
        if(
           CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||           
           CPF.equals("33333333333") || CPF.equals("33333333333") || CPF.equals("44444444444") ||
           CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") ||
           CPF.equals("88888888888") || CPF.equals("99999999999") || CPF.length() != 11){
            return false;
        }
        
        numMult = 10;
        i = 0;
        result = 0;
        while (numMult >= 2) {
            numCpf = Integer.parseInt(CPF.substring(i,i+1));
            result = result + numCpf * numMult;
            numMult -= 1;
            i += 1;
        }
        result = result * 10;
        result = result % 11;
        if (result == 10) {
            result = 0;
        }
        if (result == Integer.parseInt(CPF.substring(9,10))) {
            numMult = 11;
            i = 0;
            result = 0;
            while (numMult >= 2) {
                numCpf = Integer.parseInt(CPF.substring(i,i+1));
                result = result + numCpf * numMult;
                numMult -= 1;
                i += 1;
            }
            result = result * 10;
            result = result % 11;
            if (result == 10) {
                result = 0;
            }
            if (result == Integer.parseInt(CPF.substring(10,11))) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}