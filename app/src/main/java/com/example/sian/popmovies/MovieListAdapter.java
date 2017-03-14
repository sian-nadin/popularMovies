package com.example.sian.popmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sian on 14/03/2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        final MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        Movie movie = mMovieList.get(position);
        //Use picasso to load images from TMDB
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.movieItemView);
    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    public void setMovieList(List<Movie> movieList){
        this.mMovieList = new ArrayList<>();
        this.mMovieList.addAll(movieList);
        //Adapter needs to know the data has changed
        notifyDataSetChanged();

    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public final ImageView movieItemView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            movieItemView = (ImageView) itemView.findViewById(R.id.movie_poster_thumbnail);
        }
    }

}
