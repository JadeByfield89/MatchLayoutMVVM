package com.permoveo.matchlayoutmvvm.data;

import com.google.gson.annotations.SerializedName;
import com.permoveo.matchlayoutmvvm.model.Match;

import java.util.List;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchResponse {

    @SerializedName("data")
    private List<Match> matchList;


    public List<Match> getMatchList() {

        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
