package ifpb.mobile.login_interfase_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ifpb.mobile.login_interfase_mobile.seguranca.LoginUsuario;

public class LoginActivity extends AppCompatActivity {

    // Organizar os componentes
    ViewHolder mViewHolder = new ViewHolder();

    LoginUsuario loginUsuario;

    ArrayList<LoginUsuario> dadoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        mViewHolder.usuarioText = findViewById(R.id.usuario);
        mViewHolder.senhaText = findViewById(R.id.senha);
        mViewHolder.btnConfir = findViewById(R.id.btn_confir);
        mViewHolder.intent = new Intent(this, FinalActivity.class);


        dadoUsuario = new ArrayList<LoginUsuario>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewHolder.btnConfir.setOnClickListener(event -> iniciarTransferencia());
    }

    private class ViewHolder {
        EditText usuarioText;
        EditText senhaText;
        Button btnConfir;
        String usuario;
        String senha;
        Intent intent;
    }

    private void cadastrarDados(){

        loginUsuario = new LoginUsuario();
        loginUsuario.setUsuario(mViewHolder.usuario);
        loginUsuario.setSenha(mViewHolder.senha);

        dadoUsuario.add(loginUsuario);
    }

    public void iniciarTransferencia(){

        // resgata os dados informados pelo o usuario
        mViewHolder.usuario = String.valueOf(mViewHolder.usuarioText.getText());
        mViewHolder.senha = String.valueOf(mViewHolder.senhaText.getText());

        // Organizando os dados para serem passados para uma outra activity
        cadastrarDados();

        mViewHolder.intent.putExtra("dadoUsuario", dadoUsuario.get(0));

        startActivity(mViewHolder.intent);
    }

}