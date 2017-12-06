package fr.busin.tmdbsample;

import android.os.Bundle;

/**
 * Created by wali on 04/12/2017.
 */

public class AboutActivity extends BaseDrawerActivity {


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_about, frameLayout);
        setTitle(getString(R.string.about));

    }


}

