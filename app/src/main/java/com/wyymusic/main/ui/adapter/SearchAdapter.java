package com.wyymusic.main.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wyymusic.main.R;
import com.wyymusic.main.model.SearchResponse;
import com.wyymusic.main.util.MusicUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<SearchResponse.Result.Songs> mData = new ArrayList<>();
    private onItemClick onItemClick;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtSongName.setText(mData.get(position).getName());
        String singerName = "";
        for (SearchResponse.Result.Songs.Artists artist : mData.get(position).getArtists()) {
            singerName += artist.getName() + " ";
        }

        holder.txtSinger.setText(singerName);
        holder.txtSongAlbum.setText(mData.get(position).getAlbum().getName());

        holder.searchItem.setTag(position);
        holder.searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickPosition = (int) holder.searchItem.getTag();
                onItemClick.setOnItemClickListener(mData.get(clickPosition));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSongName;
        TextView txtSinger;
        TextView txtSongAlbum;
        RelativeLayout searchItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongName = itemView.findViewById(R.id.txtSongName);
            txtSinger = itemView.findViewById(R.id.txtSinger);
            txtSongAlbum = itemView.findViewById(R.id.txtSongAlbum);
            searchItem = itemView.findViewById(R.id.search_item);
        }
    }

    public void setData(Context context, List<SearchResponse.Result.Songs> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public SearchAdapter.onItemClick getOnItemClick() {
        return onItemClick;
    }

    public void setOnItemClick(SearchAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface onItemClick {
        void setOnItemClickListener(SearchResponse.Result.Songs song);
    }
}
