package com.alif.submission.favapp;

import android.net.Uri;

public class Utility {
    public static final String TABLE_MOVIE = "favorite_movies";
    public static final String TABLE_SHOW = "favorite_shows";
    public static final String AUTHORITY_MOVIE = "com.alif.submission.mdb.provider";
    public static final String AUTHORITY_SHOW = "com.alif.submission.mdb.provider";
    public static final Uri CONTENT_MOVIE_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY_MOVIE)
            .appendPath(TABLE_MOVIE)
            .build();

    public static final Uri CONTENT_SHOW_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY_SHOW)
            .appendPath(TABLE_SHOW)
            .build();

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_OVERVIEW = "overview";
    public static final String COLUMN_POSTER = "poster_url";
}
