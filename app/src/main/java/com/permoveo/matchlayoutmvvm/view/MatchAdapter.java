package com.permoveo.matchlayoutmvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.permoveo.matchlayoutmvvm.R;
import com.permoveo.matchlayoutmvvm.databinding.ItemMatchBinding;
import com.permoveo.matchlayoutmvvm.model.Match;
import com.permoveo.matchlayoutmvvm.viewmodel.MatchItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private List<Match> mMatchList;

    public MatchAdapter() {
        this.mMatchList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemMatchBinding itemMatchBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_match, parent, false);
        return new ViewHolder(itemMatchBinding);
    }

    @Override
    public int getItemCount() {
        return mMatchList.size();
    }

    public void setMatchList(List<Match> matches) {
        this.mMatchList = matches;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindMatch(mMatchList.get(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        ItemMatchBinding itemMatchBinding;

        public ViewHolder(ItemMatchBinding binding) {
            super(binding.itemMatch);
            this.itemMatchBinding = binding;

        }


        void bindMatch(Match match) {
            if (itemMatchBinding.getMatchItemViewModel() == null) {
                itemMatchBinding.setMatchItemViewModel(new MatchItemViewModel(match, itemView.getContext()));

            } else {
                itemMatchBinding.getMatchItemViewModel().setMatch(match);
            }
        }


    }
}
