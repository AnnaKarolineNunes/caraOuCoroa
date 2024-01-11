package br.com.cursoandroid.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageCaraOuCoroa;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCaraOuCoroa = findViewById(R.id.imageCaraOuCoroa);
        imageButton = findViewById(R.id.imageButtonJogar);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);


                // Passar dados para a proxima tela
                int numero = new Random().nextInt(2);

                intent.putExtra("numero", numero);
                startActivity(intent);
            }
        });


    }
}