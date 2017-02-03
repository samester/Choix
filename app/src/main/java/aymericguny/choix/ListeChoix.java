package aymericguny.choix;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by aymeric on 31/01/2017.
 */

public class ListeChoix extends ArrayList<UnChoix> implements Parcelable {

    public ListeChoix()
    {

    }



    protected ListeChoix(Parcel in) {
        this.getFromParcel(in);
    }

    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public ListeChoix createFromParcel(Parcel in) {
            return new ListeChoix(in);
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        int size = this.size();
        dest.writeInt(size);
        for(int i = 0; i < size; i++)
        {
            UnChoix unChoix = this.get(i);
            dest.writeString(unChoix.getNom());
            dest.writeInt(unChoix.getPourcen());
        }

    }
    public void getFromParcel(Parcel in)
    {
        // On vide la liste avant tout remplissage
        this.clear();

        //Récupération du nombre d'objet
        int size = in.readInt();

        //On repeuple la liste avec de nouveau objet
        for(int i = 0; i < size; i++)
        {
            UnChoix unChoix = new UnChoix();
            unChoix.setNom(in.readString());
            unChoix.setPourcen(in.readInt());
            this.add(unChoix);
        }

    }
}
