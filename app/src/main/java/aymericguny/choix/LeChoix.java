package aymericguny.choix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LeChoix extends AppCompatActivity {

    ListView mListView;
    ArrayAdapter aa;
    ListeChoix laListe;
    int nbChoix;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_choix);
        Bundle b = getIntent().getExtras();
        laListe = b.getParcelable("IDLISTE");
        nbChoix = b.getInt("NBCHOIX");
        mListView = (ListView) findViewById(R.id.liste);
        mTextView = (TextView) findViewById(R.id.textView2);
        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, laListe);
        mListView.setAdapter(aa);
        choixResult();
    }

    protected void choixResult(){
        int gagnant = 0;
        for(int i = 1; i < laListe.size(); i++)
        {
            if(laListe.get(gagnant).getPourcen() < laListe.get(i).getPourcen())
            {
                gagnant = i;
            }
        }
        mTextView.setText("Le résultat est : "+ laListe.get(gagnant).getNom());
    }
}
