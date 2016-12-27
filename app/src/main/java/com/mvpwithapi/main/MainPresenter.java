package com.mvpwithapi.main;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Hari Prasad on 12/27/16.
 */

public class MainPresenter implements MainMvp.Presenter {
    private MainMvp.View view;
    private MainMvp.Model model;
    private Subscription subscription = null;

    public MainPresenter(MainMvp.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MainMvp.View view) {
        this.view = view;
    }

    @Override
    public void rxUnSubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void loadData() {
        subscription = model.users().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MainBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.showMessage(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onNext(List<MainBean> models) {
                        if (view != null) {
                            view.updateData(models);
                        }
                    }
                });
    }
}
