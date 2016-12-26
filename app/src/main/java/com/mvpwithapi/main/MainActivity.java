package com.mvpwithapi.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mvpwithapi.R;
import com.mvpwithapi.root.App;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainMvp.View {
    private static final String TAG = "Activity";
    @Inject
    MainMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnSubscribe();
    }

    @Override
    public void updateData(List<MainBean> models) {
        Log.i(TAG, "updateData: " + models.size());
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
