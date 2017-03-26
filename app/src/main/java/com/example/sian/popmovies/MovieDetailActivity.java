package com.example.sian.popmovies;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "movie";

    private Movie mMovie;
    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;
//    TextView rating;
    TextView releaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //Store intent that started this activity
        Intent intentThatStartedThisActivity = getIntent();
        //Check if intent has extra data we passed it from Main activity
        if (intentThatStartedThisActivity.hasExtra(EXTRA_MOVIE)) {
            mMovie = intentThatStartedThisActivity.getParcelableExtra(EXTRA_MOVIE);
        } else {
            throw new IllegalArgumentException("Detail activity must receive a movie parcelable");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(mMovie.getTitle());

        RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.star_rating_bar); // initiate a rating bar
        double ratingNumber = mMovie.getVoteAverage(); // get user rating
        simpleRatingBar.setRating((float) ratingNumber); // set rating

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.movie_title);
        description = (TextView) findViewById(R.id.movie_description);
        poster = (ImageView) findViewById(R.id.movie_poster);
//        rating = (TextView) findViewById(R.id.movie_user_rating);
        releaseDate = (TextView) findViewById(R.id.movie_release_date);

        title.setText(mMovie.getTitle());
        description.setText(mMovie.getDescription());
        releaseDate.setText(mMovie.getReleaseDate());
//        rating.setText((int) mMovie.getVoteAverage());
        Picasso.with(this)
                .load(mMovie.getPoster())
                .into(poster);
        Picasso.with(this)
                .load(mMovie.getBackdrop())
                .into(backdrop);
    }

}
