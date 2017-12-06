package fr.busin.tmdbsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import fr.busin.tmdbsample.models.Movie;
import fr.busin.tmdbsample.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fr.busin.tmdbsample.services.impl.ApiServiceImpl.getMovieApiService;
import static fr.busin.tmdbsample.utils.Constants.API_KEY;
public class MainActivity extends BaseDrawerActivity {


    List<Movie> movies = new ArrayList<>();
    MovieAdapter adaper = null;
    RecyclerView rv;
    Context context;
     public static int layout ;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
   getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
              context = this;


        rv = (RecyclerView) findViewById(R.id.moviesList);
         linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
         gridLayoutManager = new GridLayoutManager(this, 3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        getPopularMovies();

    }
    private void setView() {
        if (layout == 2) {
            rv.setLayoutManager(gridLayoutManager);

        }
        else if (layout == 1){
            rv.setLayoutManager(linearLayoutManager);
        } else {

            rv.setLayoutManager(linearLayoutManager);
        }
        rv.setAdapter(adaper);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.change_layout) {
            layout = ++layout%3;
            setView();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


    private void getPopularMovies() {
        ApiService service = getMovieApiService();


        //APPEL RETROFIT


        service.getPopularMovies(API_KEY).enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {

                movies = response.body().getResults();
                adaper = new MovieAdapter(context, movies) ;
                rv.setAdapter(adaper);

            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                Log.v("sqfd","sqdf");
                //customCallBack.onError("Impossible de recupérer les films populaires");
            }
        });
    }
}
