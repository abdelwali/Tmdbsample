package fr.busin.tmdbsample.services;


import fr.busin.tmdbsample.models.Movie;
import fr.busin.tmdbsample.models.Serie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<Movie.MovieResult> getPopularMovies(@Query("api_key") String apiKey);

    @GET("tv/popular")
    Call<Serie.SerieResult> getPopularSeries(@Query("api_key") String apiKey);


}
