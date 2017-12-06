package fr.busin.tmdbsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static fr.busin.tmdbsample.R.id.tv_image;

/**
 * Created by wali on 27/11/2017.
 */

public class SerieDetail extends AppCompatActivity{
    TextView original_name;
    TextView description;
    TextView rating;
    ImageView image;

    public void onCreate(Bundle savedInstanceState){
        image= (ImageView) findViewById(tv_image);
        original_name = (TextView) findViewById(R.id.tv_nom);
        rating = (TextView) findViewById(R.id.tv_reat);
        description =(TextView) findViewById(R.id.tv_description);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_detail);
        Intent intent = getIntent();
        original_name = (TextView) findViewById(R.id.tv_nom);
        rating = (TextView) findViewById(R.id.tv_reat);
        description  = (TextView) findViewById(R.id.tv_description);
        image  = (ImageView) findViewById(tv_image);
        original_name.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));
        rating.setText(intent.getStringExtra("rating"));
        String gettingImageUrl = getIntent().getStringExtra("image");
        Picasso.with(SerieDetail.this).load(gettingImageUrl).into(image);

    }


}









