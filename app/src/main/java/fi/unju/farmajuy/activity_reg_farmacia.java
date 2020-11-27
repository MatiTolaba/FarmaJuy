package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_reg_farmacia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_farmacia);

        //poner el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }
}