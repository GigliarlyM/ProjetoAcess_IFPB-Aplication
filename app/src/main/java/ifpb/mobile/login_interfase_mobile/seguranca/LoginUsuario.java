package ifpb.mobile.login_interfase_mobile.seguranca;

import java.io.Serializable;

public class LoginUsuario implements Serializable {
    public String usuario;
    public String senha;
    public String salaEscolhida;

    public void setUsuario(String user){
        this.usuario = user;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setSalaEscolhida(String salaEscolhida) {
        this.salaEscolhida = salaEscolhida;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getSalaEscolhida(){
        return this.salaEscolhida;
    }
}
