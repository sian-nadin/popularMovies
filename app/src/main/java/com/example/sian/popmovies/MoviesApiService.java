package com.example.sian.popmovies;

import retrofit.Callback;
import retrofit.http.GET;

public interface MoviesApiService {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);

}
