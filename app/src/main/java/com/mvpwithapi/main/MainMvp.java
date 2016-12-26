package com.mvpwithapi.main;

import java.util.List;

import rx.Observable;

/**
 * Created by Hari Prasad on 12/26/16.
 */

public interface MainMvp {

    interface View {

        void updateData(List<MainBean> model);

        void showMessage(String s);

    }

    interface Presenter {

        void loadData();

        void rxUnSubscribe();

        void setView(MainMvp.View view);
    }

    interface Model {
        Observable<List<MainBean>> users();
    }
}
