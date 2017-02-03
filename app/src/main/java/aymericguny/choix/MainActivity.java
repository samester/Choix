package aymericguny.choix;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int nbCalc = 100000;

    private View mProgressView;
    private View mMainView;
    private ListView listeDesChoix;
    private EditText choixAAjoute;
    private SeekBar choixNbCalcul;
    private TextView afficheNbCalcul;
    private Button ajouterChoix;
    private Button faireChoix;
    private ListeChoix laListe;
    private ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressView = (View) findViewById(R.id.calcul_progress);
        mMainView = (View) findViewById(R.id.main);
        listeDesChoix = (ListView) findViewById(R.id.laListe);
        choixAAjoute = (EditText) findViewById(R.id.editText);
        choixNbCalcul = (SeekBar) findViewById(R.id.seekBar);
        afficheNbCalcul = (TextView) findViewById(R.id.textView);
        ajouterChoix = (Button) findViewById(R.id.ajouter);
        faireChoix = (Button) findViewById(R.id.button);
        laListe = new ListeChoix();
        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, laListe);
        listeDesChoix.setAdapter(aa);
        afficheNbCalcul.setText("Nombre de calcul :" + nbCalc);

        choixNbCalcul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nbCalc = 100000*(progress + 1);
                afficheNbCalcul.setText("Nombre de calcul :" + nbCalc);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ajouterChoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptAdd();
            }
        });

        faireChoix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(laListe.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Aucun choix possible", Toast.LENGTH_LONG).show();
                }
                else {
                    calcul();
                    Intent i = new Intent(MainActivity.this, LeChoix.class);
                    i.putExtra("IDLISTE", (Parcelable) laListe);
                    i.putExtra("NBCALC", nbCalc);
                    startActivity(i);
                    laListe.clear();
                    majListe();
                }
            }
        });

    }

    protected void attemptAdd()
    {
        choixAAjoute.setError(null);
        View mFocusView = null;

        boolean cancel = false;
        String choix = String.valueOf(choixAAjoute.getText());


        if(TextUtils.isEmpty(choix)){
            choixAAjoute.setError("Ce champ est requis");
            mFocusView = choixAAjoute;
            cancel = true;
        }
        if(cancel){
            mFocusView.requestFocus();
        } else {
            laListe.add(new UnChoix(choix));
            choixAAjoute.setText("");
            majListe();
        }
    }

    protected void majListe(){
        aa.notifyDataSetChanged();
    }

    protected void calcul(){
        int aleatoire;

        for(int i = 0; i < nbCalc; i++)
        {
            aleatoire = (int) (Math.random() * laListe.size());
            laListe.get(aleatoire).setPourcenPP();
        }
    }
}
