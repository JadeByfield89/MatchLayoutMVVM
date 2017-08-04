package com.permoveo.matchlayoutmvvm.application;

import android.app.Application;
import android.content.Context;

import com.permoveo.matchlayoutmvvm.data.MatchFactory;
import com.permoveo.matchlayoutmvvm.data.MatchService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchLayoutMVVMApplication extends Application {

    private MatchService mMatchService;
    private Scheduler mScheduler;


    private static MatchLayoutMVVMApplication get(Context context) {

        return (MatchLayoutMVVMApplication) context.getApplicationContext();
    }

    public static MatchLayoutMVVMApplication create(Context context) {
        return MatchLayoutMVVMApplication.get(context);
    }


    public MatchService getMatchService() {

        if (mMatchService == null) {

            mMatchService = MatchFactory.create();
        }

        return mMatchService;
    }

    public Scheduler subscribeScheduler(){

        if(mScheduler == null){
            mScheduler = Schedulers.io();
        }

        return mScheduler;
    }


    public void setMatchService(MatchService matchService) {
        this.mMatchService = matchService;

    }

    public void setScheduler(Scheduler scheduler) {
        this.mScheduler = scheduler;

    }
}


