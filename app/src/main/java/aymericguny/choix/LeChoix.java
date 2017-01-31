package aymericguny.choix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LeChoix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_choix);
        Bundle b = getIntent().getExtras();
        ListeChoix laListe = b.getParcelable("IDLISTE");
    }
}
