package fr.busin.tmdbsample.services.impl;


import java.util.ArrayList;
import java.util.List;

import fr.busin.tmdbsample.models.Movie;
import fr.busin.tmdbsample.models.Serie;
import fr.busin.tmdbsample.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static fr.busin.tmdbsample.utils.Constants.API_KEY;
import static fr.busin.tmdbsample.utils.Constants.BASE_URL;

/**
 * Created by adrien on 01/09/2017.
 */

public class ApiServiceImpl {

    public static ApiService getMovieApiService() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return restAdapter.create(ApiService.class);
    }
    public static ApiService getSerieApiService() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return restAdapter.create(ApiService.class);
    }


    public List<Movie> getPopularMovies(final CustomCallBack<Movie> customCallBack) {
        final List<Movie> movies = new ArrayList<>();
        ApiService service = getMovieApiService();


        //APPEL RETROFIT
        service.getPopularMovies(API_KEY).enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {

                Movie.MovieResult movieResult = response.body();

                if (movieResult != null) {
                    for (Movie movie : movieResult.getResults()) {
                        if (movie.getBackdrop() != null && movie.getPoster() != null) {
                            movies.add(movie);
                        }
                    }
                }
                customCallBack.onSuccess(movies);
            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                customCallBack.onError("Impossible de recupérer les films populaires");
            }
        });


        return movies;
    }
    public interface CustomCallBack<T> {
        void onSuccess(List<T> movies);

        void onError(String message);
    }

    public List<Serie> getPopularSeries(final CustomCallBack<Serie> customCallBack) {
        final List<Serie> series = new ArrayList<>();
        ApiService service = getSerieApiService();


        //APPEL RETROFIT
        service.getPopularSeries(API_KEY).enqueue(new Callback<Serie.SerieResult>() {
            @Override
            public void onResponse(Call<Serie.SerieResult> call, Response<Serie.SerieResult> response) {

                Serie.SerieResult serieResult = response.body();

                if (serieResult != null) {
                    for (Serie serie : serieResult.getResults()) {
                        if (serie.getBackdrop() != null && serie.getPoster() != null) {
                            series.add(serie);
                        }
                    }
                }
                customCallBack.onSuccess(series);
            }

            @Override
            public void onFailure(Call<Serie.SerieResult> call, Throwable t) {
                customCallBack.onError("Impossible de recupérer les Series populaires");
            }
        });

        return series;
    }



}
