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
import com.wyymusic.main.model.HomeRoundResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/7
 * target:
 * time: 2021/1/7
 * God Bless my code!
 **/
public class HomeRoundAdapter extends RecyclerView.Adapter<HomeRoundAdapter.ViewHolder> {
    private List<HomeRoundResponse.Data> mData = new ArrayList<>();
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_round_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getIconUrl()).into(holder.mImgRound);
        holder.roundName.setText(mData.get(position).getName());
        // TODO 圆形图标的点击事件
//        holder.mImgRound.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgRound;
        TextView roundName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgRound = itemView.findViewById(R.id.imgRound);
            roundName = itemView.findViewById(R.id.roundName);
        }
    }

    public void setData(Context context, List<HomeRoundResponse.Data> data) {
        mContext = context;
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
