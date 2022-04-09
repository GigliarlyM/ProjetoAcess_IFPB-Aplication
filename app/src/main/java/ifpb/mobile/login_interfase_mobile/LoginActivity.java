package ifpb.mobile.login_interfase_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ifpb.mobile.login_interfase_mobile.seguranca.LoginUsuario;

public class LoginActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mViewHolder.usuarioText = findViewById(R.id.usuario);
        mViewHolder.senhaText = findViewById(R.id.senha);
        mViewHolder.btnConfir = findViewById(R.id.btn_confir);
        mViewHolder.intent = new Intent(this, FinalActivity.class);
    }

    private void loginUsuario(){
        LoginUsuario loginUsuario = new LoginUsuario();

        loginUsuario.setUsuario(mViewHolder.usuario);
        loginUsuario.setSenha(mViewHolder.senha);
    }

    private class ViewHolder {
        EditText usuarioText;
        EditText senhaText;
        Button btnConfir;
        String usuario;
        String senha;
        Intent intent;
    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewHolder.btnConfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // resgata os dados informados pelo o usuario
                mViewHolder.usuario = String.valueOf(mViewHolder.usuarioText.getText());
                mViewHolder.senha = String.valueOf(mViewHolder.senhaText.getText());

                loginUsuario();
                startActivity(mViewHolder.intent);
            }
        });

    }
}