package com.wyymusic.main.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wyymusic.main.R;
import com.wyymusic.main.model.SingerHotSongsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/11
 * target:
 * time: 2021/1/11
 * God Bless my code!
 **/
public class HotSongsAdapter extends RecyclerView.Adapter<HotSongsAdapter.ViewHolder> {

    private List<SingerHotSongsResponse.Songs> mData = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_songs_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtHotSongsTitle.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtHotSongsTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHotSongsTitle = itemView.findViewById(R.id.txtHotSongsTitle);
        }
    }

    public void setData(List<SingerHotSongsResponse.Songs> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
