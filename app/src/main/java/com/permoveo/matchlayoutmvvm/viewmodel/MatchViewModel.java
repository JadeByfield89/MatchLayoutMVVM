package com.permoveo.matchlayoutmvvm.viewmodel;


import android.content.Context;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.permoveo.matchlayoutmvvm.application.MatchLayoutMVVMApplication;
import com.permoveo.matchlayoutmvvm.data.MatchResponse;
import com.permoveo.matchlayoutmvvm.data.MatchService;
import com.permoveo.matchlayoutmvvm.model.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by byfieldj on 8/4/17.
 */

public class MatchViewModel extends Observable {

    public ObservableInt mProgress;
    public ObservableInt mRecycler;

    private List<Match> mMatchList;

    private Context mContext;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public MatchViewModel(@NonNull  Context context){
        this.mContext = context;
        this.mMatchList = new ArrayList<>();

        mProgress = new ObservableInt(View.VISIBLE);
        mRecycler = new ObservableInt(View.GONE);

        fetchMatchList();

    }

    public void fetchMatchList(){

        MatchLayoutMVVMApplication application = MatchLayoutMVVMApplication.create(mContext);
        MatchService matchService = application.getMatchService();


        Disposable disposable = matchService.fetchMatches()
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MatchResponse>() {
                    @Override
                    public void accept(@NonNull MatchResponse matchResponse) throws Exception {

                        changeMatchDataSet(matchResponse.getMatchList());
                        mProgress.set(View.GONE);
                        mRecycler.set(View.VISIBLE);
                        Log.d("MatchViewModel", "Match Response -> " + matchResponse.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mRecycler.set(View.GONE);
                        mProgress.set(View.VISIBLE);
                        Log.d("MatchViewModel", "Something went wrong -> " + throwable.getLocalizedMessage());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    private void changeMatchDataSet(List<Match> matches){
        mMatchList.addAll(matches);
        setChanged();
        notifyObservers();

    }

    public List<Match> getMatchList(){

        return mMatchList;
    }

    private void unsubscribeFromObservable(){
        if(mCompositeDisposable != null && !mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

    public void reset(){
        unsubscribeFromObservable();
        mCompositeDisposable = null;
        mContext = null;
    }



}
