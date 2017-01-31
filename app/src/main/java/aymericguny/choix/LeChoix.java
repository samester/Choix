package aymericguny.choix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LeChoix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_choix);
        Bundle b = getIntent().getExtras();
        ListeChoix laListe = b.getParcelable("IDLISTE");
        Log.v(laListe.get(0).getNom()+laListe.get(0).getPourcen(), "After ");
    }
}
