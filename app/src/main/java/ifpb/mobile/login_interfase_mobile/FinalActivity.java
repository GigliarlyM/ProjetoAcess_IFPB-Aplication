package ifpb.mobile.login_interfase_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import ifpb.mobile.login_interfase_mobile.seguranca.LoginUsuario;

public class FinalActivity extends AppCompatActivity{

    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Intent intent;
    private LoginUsuario loginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prots);
        getSupportActionBar().hide();

        loginUsuario = (LoginUsuario) getIntent().getSerializableExtra("dadoUsuario");

        radio1 = findViewById(R.id.radioButtonPROT1);
        radio2 = findViewById(R.id.radioButtonPROT2);
        radio3 = findViewById(R.id.radioButtonPROT3);
        radio4 = findViewById(R.id.radioButtonPROT4);

        intent = new Intent(this, InicialActivity.class);

        radio1.setOnClickListener(event -> escolhaRadio(radio1));
        radio2.setOnClickListener(event -> escolhaRadio(radio2));
        radio3.setOnClickListener(event -> escolhaRadio(radio3));
        radio4.setOnClickListener(event -> escolhaRadio(radio4));
    }

    private void escolhaRadio(View view){

        switch (view.getId()){
            case R.id.radioButtonPROT1:
                loginUsuario.setSalaEscolhida("sala 1");
                break;

            case R.id.radioButtonPROT2:
                loginUsuario.setSalaEscolhida("sala 2");
                break;

            case R.id.radioButtonPROT3:
                loginUsuario.setSalaEscolhida("sala 3");
                break;

            case R.id.radioButtonPROT4:
                loginUsuario.setSalaEscolhida("sala 4 (laiser)");
                break;

            default:
                loginUsuario.setSalaEscolhida("Novo componente");
                break;
        }

        String id = loginUsuario.getSalaEscolhida();
        Toast.makeText( this,
                String.format("você escolheu: %s \n %s \n %s",
                        id, loginUsuario.getUsuario(), loginUsuario.getSenha()),
                Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

}