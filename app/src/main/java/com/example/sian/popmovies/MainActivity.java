package com.example.sian.popmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieListAdapter mMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a handle to the recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.main_act_recycler_view);
        //Create an adapter & supply the data
        mMovieListAdapter = new MovieListAdapter(this);
        //Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mMovieListAdapter);
        //Give the RecyclerView a default Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Movie> movies = new ArrayList<>();
        for (int i=0; i<25; i++){
            movies.add(new Movie());
        }
        mMovieListAdapter.setMovieList(movies);

    }


}
