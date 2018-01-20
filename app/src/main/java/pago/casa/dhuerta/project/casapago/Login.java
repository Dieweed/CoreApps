package pago.casa.dhuerta.project.casapago;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtUser, txtPass;
    Button btnEntrar;
    ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        relacionarXML();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Login() == true)
                {

                }else{
                    Toast.makeText(getApplicationContext(), "Disculpe sus credenciales son Incorrectas", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void relacionarXML()
    {
        txtUser = (EditText) findViewById(R.id.user);
        txtPass = (EditText) findViewById(R.id.password);
        btnEntrar = (Button) findViewById(R.id.entrar);

        progressDialog = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Cargando...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
    }

    public boolean Login()
    {
        return true;
    }
}
