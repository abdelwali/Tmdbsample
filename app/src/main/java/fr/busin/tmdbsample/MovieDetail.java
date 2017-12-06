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

public class MovieDetail extends AppCompatActivity{
    TextView title;
    TextView description;
    TextView rating;
    ImageView image;

    public void onCreate(Bundle savedInstanceState){
        image= (ImageView) findViewById(tv_image);
        title = (TextView) findViewById(R.id.tv_nom);
        rating = (TextView) findViewById(R.id.tv_reat);
        description =(TextView) findViewById(R.id.tv_description);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent intent = getIntent();
         title = (TextView) findViewById(R.id.tv_nom);
        rating = (TextView) findViewById(R.id.tv_reat);
        description  = (TextView) findViewById(R.id.tv_description);
        image  = (ImageView) findViewById(tv_image);

        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));

        rating.setText(intent.getStringExtra("rating"));
        String gettingImageUrl = getIntent().getStringExtra("image");

        Picasso.with(MovieDetail.this).load(gettingImageUrl).into(image);

    }


}







