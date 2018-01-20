package pago.casa.dhuerta.project.casapago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class Splash extends AppCompatActivity {

    private boolean active = true;
    private int splashTime = 3000;
    public static DBProvider oDB;

    public Splash(){ oDB = new DBProvider(this); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        Thread splashThread = new Thread()
        {
            @Override
            public void run() {
                try{
                    int waited = 0;
                    while(active && (waited < splashTime)){
                        sleep(300);
                        if(active)
                            waited += 300;
                    }
                }catch(InterruptedException e) {
                }finally{
                    openApp();
                }
            }
        };
        splashThread.start();
    }

    private void openApp(){
        finish();
        startActivity(new Intent(this, Login.class));
    }
}
