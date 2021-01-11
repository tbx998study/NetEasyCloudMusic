package com.wyymusic.main.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wyymusic.main.R;
import com.wyymusic.main.model.HotSearchDetailResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tbx
 * @date 2021/1/5
 * target:
 * time: 2021/1/5
 * God Bless my code!
 **/
public class HotSearchAdapter extends RecyclerView.Adapter<HotSearchAdapter.ViewHolder> {

    private List<HotSearchDetailResponse.Data> mData = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_search_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTxtName.setText(mData.get(position).getSearchWord());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTxtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtName = itemView.findViewById(R.id.txtName);
        }
    }

    public void setData(Context context, List<HotSearchDetailResponse.Data> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
