package com.wyymusic.main.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wyymusic.main.R;
import com.wyymusic.main.model.TopArtistResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/9
 * target:
 * time: 2021/1/9
 * God Bless my code!
 **/
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.ViewHolder> {
    private List<TopArtistResponse.AList.Artists> mData = new ArrayList<>();
    private Context mContext;
    private onItemClickListener onItemClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_artist_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getImg1v1Url()).into(holder.mImgTop);
        holder.mTxtSingerName.setText(mData.get(position).getName());
        holder.mTxtTopLastRank.setText(mData.get(position).getLastRank() + 1 + "");
        holder.mTxtSingerScore.setText(mData.get(position).getScore() + "");
        holder.rlTopArtist.setTag(position);
        holder.rlTopArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickPosition = (int) holder.rlTopArtist.getTag();
                onItemClickListener.setOnClick(mData.get(clickPosition));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlTopArtist;
        TextView mTxtTopLastRank;
        ImageView mImgTop;
        TextView mTxtSingerName;
        TextView mTxtSingerScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlTopArtist = itemView.findViewById(R.id.rlTopArtist);
            mTxtTopLastRank = itemView.findViewById(R.id.txtTopLastRank);
            mImgTop = itemView.findViewById(R.id.imgTopSinger);
            mTxtSingerName = itemView.findViewById(R.id.txtSingerName);
            mTxtSingerScore = itemView.findViewById(R.id.txtSingerScore);
        }
    }

    public interface onItemClickListener {
        void setOnClick(TopArtistResponse.AList.Artists data);
    }

    public void setOnItemClickListener(TopArtistAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(Context context, List<TopArtistResponse.AList.Artists> data) {
        mContext = context;
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
