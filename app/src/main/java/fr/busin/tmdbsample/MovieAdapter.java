package fr.busin.tmdbsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.busin.tmdbsample.models.Movie;


/**
 * Created by adrien on 11/10/2017.
 */

class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Movie> Movies;
    boolean test;
    private Movie movie;



    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        this.Movies = movies;

    }



    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view ;


        if( MainActivity.layout ==1){
            view = inflater.inflate(R.layout.item_movie, viewGroup, false);

        } else if (MainActivity.layout ==2) {
            view = inflater.inflate(R.layout.item_movie_2, viewGroup, false);
        }
        else {
            view = inflater.inflate(R.layout.item_movie_1, viewGroup, false);
        }
        return new MovieViewHolder(view);

        }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder2,  int position) {
        final Movie movie = Movies.get(position);
        final MovieViewHolder holder = (MovieViewHolder)holder2;

        holder.tv_nom.setText(String.valueOf(movie.getTitle()));
        holder.tv_description.setText(String.valueOf(movie.getDescription()));
        String url = movie.getBackdrop();
        Picasso.with(holder.tv_image.getContext()).load(url).into(holder.tv_image);
                     holder.linear_item_movie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, MovieDetail.class);
                        intent.putExtra("description",movie.getDescription() );
                        intent.putExtra("title",movie.getTitle() );
                        intent.putExtra("image",movie.getPoster() );
                        intent.putExtra("rating",movie.getRating());
                        context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Movies.size();
    }

}

