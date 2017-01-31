package aymericguny.choix;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button faireChoix;
    private ListeChoix laListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faireChoix = (Button) findViewById(R.id.button);
        faireChoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LeChoix.class);
                i.putExtra("IDLISTE", (Parcelable) laListe);
                startActivity(i);
            }
        });

    }


}
