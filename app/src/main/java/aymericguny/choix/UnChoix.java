package aymericguny.choix;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aymeric on 31/01/2017.
 */

public class UnChoix implements Parcelable {



    String nom;
    int pourcen;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public UnChoix()
    {
        nom = "";
        pourcen = 0;
    }

    public UnChoix(String _nom)
    {
        nom = _nom;
        pourcen = 0;
    }


    public String toString(){
        return this.getPourcen()==0? (this.getNom()): (this.getNom() +"("+ this.getPourcen()+")");
    }



    public int getPourcen() {
        return pourcen;
    }

    public void setPourcen(int pourcen) {
        this.pourcen = pourcen;
    }

    public void setPourcenPP() {
        this.pourcen++;
    }


    public UnChoix(Parcel in)
    {
        this.getFromParcel(in);
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        public UnChoix createFromParcel(Parcel in)
        {
            return new UnChoix(in);
        }

        @Override
        public Object[] newArray(int size) {
            return null;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //On ecrit dans le parcel les données de notre objet
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.nom);
        dest.writeInt(this.pourcen);
    }

    //On va ici hydrater notre objet à partir du Parcel
    public void getFromParcel(Parcel in) {
        this.setNom(in.readString());
        this.setPourcen(in.readInt());
    }
}
