package com.permoveo.matchlayoutmvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.permoveo.matchlayoutmvvm.model.Match;
import com.squareup.picasso.Picasso;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchItemViewModel extends BaseObservable {

    private Match mMatch;
    private Context mContext;

    public MatchItemViewModel(Match match, Context context) {

        this.mMatch = match;
        this.mContext = context;

    }


    public String getUsername() {
        return mMatch.username;
    }

    public String getProfilePhotoUrl() {

        return mMatch.photo.thumbnail.large;
    }

    public String getAgeLocationDesc(){

        return getAge() + "•" + getCityName() + ", " + getStateCode();
    }

    public int getAge() {
        return mMatch.age;
    }

    public String getCityName() {
        return mMatch.location.city;
    }

    public String getStateCode() {

        return mMatch.location.state;
    }

    public int getMatchPercentage() {
        return mMatch.match / 100;
    }

    @Bindable
    public String getMatchPercentageString(){
        return Integer.toString(getMatchPercentage()) + "%";
    }

    public void setMatch(Match match) {
        this.mMatch = match;
        notifyChange();
    }

    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url).fit().into(imageView);
    }
}
