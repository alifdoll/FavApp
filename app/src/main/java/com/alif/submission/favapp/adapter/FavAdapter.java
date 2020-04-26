package com.alif.submission.favapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alif.submission.favapp.R;
import com.alif.submission.favapp.Utility;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    private Cursor cursor;
    private Context context;

    public FavAdapter(Context context){
        this.context = context;
    }

    public void setData(Cursor cursor){
        this.cursor = cursor;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item_list, parent, false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.bind(cursor.moveToPosition(position));
        Log.d("DEBUG_DATABASE", "BERHASIL RETRIEVE DATA");
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvOverview;
        ImageView ivPoster;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.text_view_fav_title);
            tvOverview = itemView.findViewById(R.id.text_view_fav_overview);
            ivPoster = itemView.findViewById(R.id.fav_photo);
        }

        public void bind(boolean moveToPosition){
            if (moveToPosition){
                tvTitle.setText(cursor.getString(cursor.getColumnIndexOrThrow(Utility.COLUMN_TITLE)));
                tvOverview.setText(cursor.getString(cursor.getColumnIndexOrThrow(Utility.COLUMN_OVERVIEW)));
                Glide.with(context)
                        .load(cursor.getString(cursor.getColumnIndexOrThrow(Utility.COLUMN_POSTER)))
                        .apply(new RequestOptions())
                        .into(ivPoster);
            }
        }
    }
}
