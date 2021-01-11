package com.wyymusic.main.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wyymusic.main.R;
import com.wyymusic.main.model.RecommendSongsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class RecommendSongsAdapter extends RecyclerView.Adapter<RecommendSongsAdapter.ViewHolder> {

    private List<RecommendSongsResponse.Result> mData = new ArrayList<>();
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_songs_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getPicUrl()).into(holder.mImgRecommend);
        holder.mRecommendSongs.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mRecommendSongs;
        ImageView mImgRecommend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecommendSongs = itemView.findViewById(R.id.txtRecommend);
            mImgRecommend = itemView.findViewById(R.id.imgRecommend);
        }
    }

    public void setData(Context context,List<RecommendSongsResponse.Result> data) {
        mContext = context;
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
