package com.alif.submission.favapp.fragment;


import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alif.submission.favapp.R;
import com.alif.submission.favapp.Utility;
import com.alif.submission.favapp.adapter.FavAdapter;

public class MovieFragment extends Fragment {

    private static final int CODE_MOVIE = 1;
    private FavAdapter adapter;
    private RecyclerView rv;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.no_data);
        rv = view.findViewById(R.id.rv_fav_movie_list);
        adapter = new FavAdapter(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

        ContentResolver contentResolver = getContext().getContentResolver();
        Cursor cursor = contentResolver.query(Utility.CONTENT_MOVIE_URI,
                null,
                null,
                null,
                null);

        if (cursor != null && cursor.getCount() > 0){
            adapter.setData(cursor);
        }
        else {
            textView.setVisibility(View.VISIBLE);
        }
    }



}
