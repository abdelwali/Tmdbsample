package fr.busin.tmdbsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wali on 15/11/2017.
 */

public class SerieViewHolder extends RecyclerView.ViewHolder {


    TextView tv_nom;
    TextView tv_description;
    ImageView tv_image;
    View linear_item_movie;



    public SerieViewHolder(View itemViewUser) {
        super(itemViewUser);

        tv_nom = (TextView) itemView.findViewById(R.id.tv_nom);
        tv_description = (TextView) itemView.findViewById(R.id.tv_description);
        tv_image = (ImageView) itemView.findViewById(R.id.tv_image);
        linear_item_movie = (View) itemView.findViewById(R.id.linear_item_movie);

    }


    public SerieViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.activity_serie_detail, parent, false));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SerieDetail.class);
                context.startActivity(intent);
            }
        });
    }
}

