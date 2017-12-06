package fr.busin.tmdbsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.busin.tmdbsample.models.Serie;



/**
 * Created by adrien on 11/10/2017.
 */

class SerieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Serie> Series;
    private Serie serie;



    public SerieAdapter(Context context, List<Serie> series) {
        mContext = context;
        this.Series = series;

    }



    @Override
    public SerieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view ;


        if( SerieActivity.layout ==1){
            view = inflater.inflate(R.layout.item_movie, viewGroup, false);

        } else if (SerieActivity.layout ==2) {
            view = inflater.inflate(R.layout.item_movie_2, viewGroup, false);
        }
        else {
            view = inflater.inflate(R.layout.item_movie_1, viewGroup, false);
        }
        return new SerieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder2,  int position) {
        final Serie serie = Series.get(position);
        final SerieViewHolder holder = (SerieViewHolder)holder2;

        holder.tv_nom.setText(String.valueOf(serie.getOriginal_name()));
        holder.tv_description.setText(String.valueOf(serie.getDescription()));
        String url = serie.getBackdrop();
        Picasso.with(holder.tv_image.getContext()).load(url).into(holder.tv_image);
        holder.linear_item_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SerieDetail.class);
                intent.putExtra("description",serie.getDescription() );
                intent.putExtra("title",serie.getOriginal_name() );
                intent.putExtra("image",serie.getPoster() );
                intent.putExtra("rating",serie.getRating());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Series.size();
    }

}

