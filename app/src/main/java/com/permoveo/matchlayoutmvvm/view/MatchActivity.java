package com.permoveo.matchlayoutmvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.permoveo.matchlayoutmvvm.R;
import com.permoveo.matchlayoutmvvm.databinding.MatchActivityBinding;
import com.permoveo.matchlayoutmvvm.viewmodel.MatchViewModel;

import java.util.Observable;
import java.util.Observer;

public class MatchActivity extends AppCompatActivity implements Observer {


    private MatchActivityBinding mMatchActivityBinding;
    private MatchViewModel mMatchViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setupMatchListView(mMatchActivityBinding.rvRecylcer);
        setupObserver(mMatchViewModel);
    }

    private void initDataBinding(){
        mMatchActivityBinding = DataBindingUtil.setContentView(this, R.layout.match_activity);
        mMatchViewModel = new MatchViewModel(this);
        mMatchActivityBinding.setMatchViewModel(mMatchViewModel);
    }

    private void setupMatchListView(RecyclerView recyclerView){
        Log.d("MatchActivity", "setupMatchListView");

        MatchAdapter adapter = new MatchAdapter();
        recyclerView.setAdapter(adapter);
        Log.d("MatchActivity", "Set Adapter");
        int spanCount = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount, GridLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new GridItemDecoration(12));
    }

    private void setupObserver(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d("MatchActivity", "update");

        if(observable instanceof MatchViewModel){
            MatchAdapter matchAdapter = (MatchAdapter) mMatchActivityBinding.rvRecylcer.getAdapter();
            MatchViewModel matchViewModel =  (MatchViewModel) observable;
            matchAdapter.setMatchList(matchViewModel.getMatchList());
            Log.d("MatchActivity",  "setMatchList");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMatchViewModel.reset();
    }
}
