package com.dimples.ui.splash;

import android.content.Context;

import com.dimples.ui.main.MainActivity;
import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.widget.CustomCountDownTimer;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private static CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
        context = (Context) view;
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(3, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer("跳过(" + time + ")");
            }

            @Override
            public void onFinish() {
                getView().pageSwitch(context, MainActivity.class);
            }
        });
        timer.start();
    }

    private void cancel() {
        timer.cancel();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    /**
     * 防止 空指针异常
     *
     * @return ISplashActivityContract.IView
     */
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

}